@Stateless
public class LoanService implements LoanServiceRemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User createUser(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Loan createLoan(Loan loan) {
        em.persist(loan);
        System.out.println("loan persisted: id=" + loan.getId());
        return loan;
    }

    @Override
    public Loan saveLoan(Loan loan) {
        em.merge(loan);
        return loan;
    }

    @Override
    public Long incrementLoan(Integer loanId, long amount) {
        Loan loan = em.find(Loan.class, loanId);
        if (loan != null) {
            long sum = loan.getSum() + amount;
            /*
             * The entity is bound to the entity manager,
             * because it was returned by the find method.
             * We can simply set its properties and
             * the entity manager will update the datasource
             * after the method returns and the transaction commits. 
             * No need to call persist or merge.
             */
            loan.setSum(sum);
            return sum;
        }
        return null;
    }

    @Override
    public boolean deleteLoan(Integer loanId) {
        Loan loan = em.find(Loan.class, loanId);
        if (loan != null) {
            em.remove(loan);
            return true;
        }
        return false;
    }

    @Override
    public Loan findLoan(Integer loanId) {
        return em.find(Loan.class, loanId);
    }

    @Override
    public List<Loan> requestLoans(LoanRequest loanRequest) {
        User user;
        TypedQuery<User> query = em.createQuery("select user from User user where user.firstName = :firstName and user.lastName = :lastName", User.class);
        query.setParameter("firstName", loanRequest.getFirstName());
        query.setParameter("lastName", loanRequest.getLastName());
        List<User> users = query.getResultList();
        if (users.isEmpty()) {
            user = new User();
            user.setFirstName(loanRequest.getFirstName());
            user.setLastName(loanRequest.getLastName());
            //new entities must be persisted
            em.persist(user);
        } else {
            user = users.get(0);
        }

        List<Loan> loans = new ArrayList<>();
        Long[] totals = loanRequest.getTotals();
        for (int i = 0; i < totals.length; i++) {
            Loan loan = new Loan();
            loan.setSum(totals[i]);
            loan.setUser(user);
            em.persist(loan);
            loans.add(loan);
        }

        return loans;
    }
}
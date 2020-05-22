@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="loan", referencedColumnName="loan_id")
    private Loan loan;

 public Loan getLoan() {
        return loan;
    }
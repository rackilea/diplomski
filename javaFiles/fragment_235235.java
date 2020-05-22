public class Loans {

    private final List<Loan> loans;

    public Loans(List<Loan> loans) {
        this.loans = loans.stream()
                .sorted(Comparator.comparingInt(Loan::getDuration))
                .collect(Collectors.toList());
    }

    public Stream<Loan> getUpTo(int duration) {
        return loans.stream().takeWhile(l -> l.getDuration() <= duration);
    }

}
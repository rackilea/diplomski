public class LoanData {

    private final double rate ;
    private final int year ;
    private final double loan ;

    public LoanData(double rate, int year, double loan) {
        this.rate = rate ;
        this.year = year ;
        this.loan = loan ;
    }

    public double getRate() {
        return rate ;
    }
    public int getYear() {
        return year ;
    }
    public double getLoan() {
        return loan ;
    }
}
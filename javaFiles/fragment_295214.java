public class Conto {

    private String Nome;
    private double Saldo;

    public Conto(String Nome, double SaldoIniziale) {
        this.Nome = Nome;
        this.Saldo = SaldoIniziale;
    }

    public void versamento(double appoggio) {
        Saldo += appoggio;
    }

    public boolean prelievo(double appoggio) {
        if (Saldo <= -1000) return false;
        Saldo -= appoggio;
        return true;
    }

    public double getSaldo() {
        return Saldo;
    }

    public String getNome() {
        return Nome;
    }

}
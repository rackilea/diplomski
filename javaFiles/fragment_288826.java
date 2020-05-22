public class AllCurrency implements Currency{

private Rupee rupee;
private SGDDollar sgdDollar;
private USDollar useDoler;

public AllCurrency (Rupee rupee,SGDDollar sgDoler,USDollar usDoller){
    this.rupee = rupee;
    this.sgdDollar = sgDoler;
    this.usDoller = usDoller
}

@Override
   public String getSymbol() {
          return "all";
   }

// add getters and setters
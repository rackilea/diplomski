public class PriceInfo {
  public int Price;
  public int ProfitOrLoss;
}

@WebMethod(operationName = "Calc")
public PriceInfo Calc(@WebParam(name = "grams") int grams, @WebParam(name = "time") int time) {
    //TODO write your implementation code here:
    if(time>11){
    a=grams*100;
    c=(grams*100-grams*80);
    }
    else if(time<11)
    {
    a=grams*80;
    c=(grams*80-grams*100);
    }

    PriceInfo result = new PriceInfo();
    result.Price = a;
    result.ProfitLoss = c;         

    return result;
}
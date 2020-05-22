public class Calculate {
  public void calculateBill (double totalofusage) {
    double amount;

    if ((totalofusage > 0) && (totalofusage <= 200))
        amount = totalofusage * 0.218;
    else if ((totalofusage > 200) && (totalofusage <=300))
        amount = totalofusage * 0.334;
    else if ((totalofusage >300) && (totalofusage <= 400))
       amount = totalofusage * 0.400;
    else 
       amount = totalofusage * 0.402;

    System.out.println ("Amount ="+ amount);
}
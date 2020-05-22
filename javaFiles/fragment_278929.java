public class BillFactory
{
    Bill createBill(String type)
    {
         if(type.equals("Electricity"))
           {
            bill=new ElectricityBill();
       }
        ........


    }
}
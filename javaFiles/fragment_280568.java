public class PizzaExamFinalOne
{
    public static void main(String[]args)
    {
        double total2 = 0;
        String customerName = " ";
        String address = " ";
        String phoneNum ="0";
        int max = 5;
        int done = 1;
        double totalPizza = 0;
        double totalA = 0;
        int pizzaChoice =0;
        String [] pizzaType = {"Placeholder",  "Hawaian" , "Classic Italian" , "Cheese Extreme" , "Veg Delight" , "Pepperoni" , "Tomato Margherita" , "Beef & Onion" , "Super Supreme" , "Meat Lovers" , "Hot 'n Spicy" , "Italiano" , "Italian Veg"};
        double [] pizzaPrice = {0, 8.5 , 8.5 , 8.5 , 8.5 , 8.5 , 8.5 , 8.5 , 13.5 , 13.5 , 13.5 , 13.5 , 13.5};
        int [] orderDisplay = {0,0,0,0,0,0,0,0,0,0,0,0,0};
        boolean pickup = true;
        int pickup1 = readInt("If you wish to pickup press 1 or  press 0 for delivery");
        if (pickup1 == 0)
        {
            pickup = false;
        }
        while (done != 0)
        {
            for (int i = 1; i <pizzaType.length; i++)
            {
                System.out.println(i + " " +pizzaType[i] + " $" + pizzaPrice[i]);
            }
            pizzaChoice = readInt ("Choose the type of pizza you wish to order");
            int pizzaQuantity = readInt ("How many " + pizzaType[pizzaChoice] + " pizzas do you wish to buy (Maximum is 5)");
            totalPizza = totalPizza + pizzaQuantity;            
            if(totalPizza > max)
            {
                totalPizza = totalPizza - pizzaQuantity;
                System.out.println("You cannot order more than five pizzas");
                pizzaChoice = 0;  
                pizzaQuantity = 0;
            }
            else
            {
                orderDisplay[pizzaChoice] = pizzaQuantity;
            }
            done= readInt ("Press 0 if you are done or press 1 to make another pizza order");
            double total1 = pizzaQuantity*pizzaPrice[pizzaChoice];
            total2 = total2 + total1;
        }
        if(totalPizza > 0)
        {
            if(pickup == false)
            {
                int deliveryCost = 3;
                customerName = readString ("Please enter your full name");
                address = readString ("Please enter the Delivery address");
                phoneNum = readString ("Please enter the phone number of " + customerName);
                totalA = total2 + deliveryCost;
                System.out.println("Delivery order for " + customerName);
                System.out.println("To " + address + ", Phone number 0" + phoneNum);
            }
            else
            {
                customerName = readString ("Please enter your full name");
                System.out.println("Pickup order for " + customerName);
                int deliveryCost = 0;
                totalA = total2 + deliveryCost;
            }
            for(int i=1;i<orderDisplay.length;i++)
            {
                if(orderDisplay[i]>0)
                {
                    System.out.println("       " + orderDisplay[i] +  " " + pizzaType[i] + " pizzas");
                }
            }
            System.out.println("The total amount of your order is " + formatMoney(totalA));
        }
        else
        {
            System.out.println("You have not ordered anything.");
        }
    }
    public static int readInt(String prompt)
    {
        System.out.println(prompt);
        java.util.Scanner keyboard = new java.util.Scanner(System.in);                                
        return keyboard.nextInt();
    }
    public static String readString (String prompt)
    {
        System.out.println (prompt);
        java.util.Scanner keyboard= new java.util.Scanner(System.in);
        return keyboard.nextLine();
    }

    public static String formatMoney(double phoneNum)
    {
        java.text.NumberFormat  fmt = java.text.NumberFormat. getCurrencyInstance();
        return(fmt.format(phoneNum));
    }
}
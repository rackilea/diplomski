public static void main(String[] args)
{
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter The Size of Pizza you" + "want: (S/M/L/C)");
    String option = keyboard.nextLine().trim().substring(0,1).toUpperCase();

    double pizzaPrice;
    double pizzaSize;

    if(option.equals(PIZZA_SMALL))
    {
        pizzaPrice = SMALL_DIAMETER;
        pizzaSize = SMALL_DIAMETER;
    }
    else if (option.equals(PIZZA_MEDIUM))
    {
        pizzaPrice = PRICE_MEDIUM;
        pizzaSize = MEDIUM_DIAMETER;
    }
    else if (option.equals(PIZZA_LARGE))
    {
        pizzaPrice = PRICE_LARGE;
        pizzaSize = LARGE_DIAMETER;
    }
    else
    {
        option = PIZZA_COLLOSAL;            
        pizzaPrice = PRICE_COLOSSAL;
        pizzaSize = COLOSSAL_DIAMETER;
    }


    System.out.println("Pizza Size: " + option);
    System.out.println("Enter The Number of Toppings" +
    "you want:(0-8)");

    int pizzaTopping = keyboard.nextInt();      

    if(pizzaTopping < MIN_TOPPINGS)
    {
        pizzaTopping = MIN_TOPPINGS;
    }
    else if(pizzaTopping > MAX_TOPPINGS)
    {
        pizzaTopping = MAX_TOPPINGS;
    }

    double radius = getDiameter(option) / 2;
    double squareInches = radius * radius * Math.PI;
    System.out.println("Pizza Size: " + option + "( " + pizzaSize + 
    "inch -- " + squareInches + " square inches)" );

    System.out.println("Toppings: " + pizzaTopping);

    double priceWithToppings = getBasePrice(option) + pizzaTopping * 9;
    System.out.println("Price: " + priceWithToppings);  

    double pizzaTax = priceWithToppings * PRICE_TAX;
    System.out.println("Tax: "+ pizzaTax);

    double totalPrice = priceWithToppings + pizzaTax;
    System.out.println("Total Price: " + totalPrice);

    double priceEachSquareInch = priceWithToppings / squareInches;
    System.out.println("Price/sq.in.: " + priceEachSquareInch);

    }
 }
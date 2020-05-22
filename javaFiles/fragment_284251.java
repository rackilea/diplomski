//Total amount of product ordered
        System.out.println("Total items ordered: " + nCount);

        //Total price of items ordered
        System.out.println("Price of items ordered: $" + dFinalPrice);

        //Sales tax associated with the purchase
        System.out.println("Sales tax: $" + SALES_TAX * dFinalPrice );

        //Total amount due by the customer to Grapefruit Co. 
        System.out.println("Total amount due: $" + (SALES_TAX * dFinalPrice + dFinalPrice ));
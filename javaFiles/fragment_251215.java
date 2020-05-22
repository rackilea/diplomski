Scanner keyboard = new Scanner (System.in);
        String nameProd;
        String response;
        int items = 0;
        int costMat;
        int hoursReq;
        int payPerHr = 15; //cost per hour for only one employee, who is also the owner (me)
        double shipping = 13.25; //shipping cost remains constant even with multiple items
        //////////////////////////////////////////////////////////////////////////////////

        List<String> orderItems = new ArrayList<>();
        double totalPrice=0;


        System.out.println("================================="
            + "\nWelcome to Ryan's Computer Store!"
            + "\n=================================");

        do{
            items++;
                //////////////////////////////////////////    
                System.out.print("Enter product name: ");
                    nameProd = keyboard.next();
                        ////////////////////////////////////////////////
                        System.out.print("Enter cost of materials: $");
                            costMat = keyboard.nextInt();
                        System.out.print("In hours, how soon would you prefer that this order is completed?: ");
                            hoursReq = keyboard.nextInt();
                            //////////////////////////////////////////////////////////////////////////////////////////
                            System.out.println("====================================================================" 
                                + "\n============================" 
                                + "\n>>>>>>Rundown of costs<<<<<<" 
                                + "\nItem #: " + items
                                + "\nItem Name: " + nameProd 
                                + "\nCost of Materials: $" + costMat 
                                + "\n===>Hours spent creating the product: " + hoursReq + " hours" 
                                + "\n===>Employee Pay Per Hour: $" + payPerHr);

                            orderItems.add(nameProd);


                            int priceMarkup = hoursReq*payPerHr;
                                //////////////////////////////////////////////////////
                                System.out.println("Price of product after markup: $" 
                                    + (priceMarkup+costMat));
                                    //////////////////////////////////////////////////////
                                    System.out.println("===>Shipping Fee: $" + shipping);
                                        //////////////////////////////////////////////
                                        int costBeforeShipping = priceMarkup+costMat;
                                        double totAmt = shipping+costBeforeShipping;
                                        totalPrice+=totAmt;
                                            //////////////////////////////////////////////////////
                                            System.out.println("Amount to be charged for item #" + items + " (" + nameProd + ")" + ": $" + totAmt
                                                + "\n============================");
                                                    //////////////////////////////////////////////////////////////////////////////
                                                    System.out.print("========================================================" 
                                                        + "\nIs there anything else that you would like to order?: ");
                                                        response = keyboard.next();
                                                        }
        while
            (response.equalsIgnoreCase("yes"));
        System.out.println(">>>>>========================================================<<<<<\nTOTAL AMOUNT TO BE CHARGED FOR  ITEMS: " + orderItems +  "\nShipping (flat fee): " + shipping + "\nSum of Items: "+totalPrice);
    }
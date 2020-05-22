name = br.readLine();
    customerReturn = br.readLine();
    type = br.readLine();
    qty = br.readLine();
    total = br.readLine();


    // build output strings
            nameOutputMsg     = "Welcome " + name + ".\n\n";
            returnOutputMsg   = "Your return customer status is " + customerReturn + ".\n";
            typeOutputMsg = "Your choice of stocking is " + type + ".\n";
            qtyOutputMsg ="You are buying " + qty + " stockings.\n";
            totalOutputMsg = "The total for your order today is $" + total + ".\n";
            greetingOutputMsg = "Thank you for visiting ThinkGeek!" + "\n\n"
                              + "You should recieve a reciept of your purchase in your email soon!\n";
            //display total cost

            outputMsg = nameOutputMsg + returnOutputMsg + typeOutputMsg + qtyOutputMsg + totalOutputMsg + greetingOutputMsg; //add outputs 
    System.out.println(outputMsg);
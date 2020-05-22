for(int i = 0;i<o.length;i++){
        o[i] = new Orders();
        System.out.println("The name of the product: ");
        String name = sc.nextLine();
        o[i].setName(name);
        System.out.println("Price of product: ");
        double price = sc.nextDouble();
        o[i].setPrice(price);
        System.out.println("Quantity of product: ");
        int quantity = sc.nextInt();
        o[i].setQuantity(quantity);
        sc.nextLine();
        System.out.println("moveing to the next Order:");
    }
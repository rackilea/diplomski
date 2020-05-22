public static void writeOrderLine(String name, Sandwich sandwich)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        try
        {
            File productsFile = new File("orderline.txt");
            PrintWriter out = new PrintWriter(
                new BufferedWriter(
                new FileWriter(productsFile, true)));

           out.print(dateFormat.format(date) + "\t");
           out.print(name + "\t");
           out.print(sandwich.getBread() + "\t");
           out.print(sandwich.getMeat() + "\t");
           out.print(sandwich.getVegetables() + "\t");
           out.println(sandwich.getPrice() + "\t");
           out.close();
       }
       catch (IOException e)
       {
           System.out.println(e);
       }
    }
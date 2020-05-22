public static void writeOrderLine(String name, String bread, String meat, String veg, double price)
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
               out.print(bread + "\t");
               out.print(meat + "\t");
               out.print(veg + "\t");
               out.println(price+ "\t");
               out.close();
           }
           catch (IOException e)
           {
               System.out.println(e);
           }
        }
try{
         Scanner read = new Scanner(new File(filename));
         while (read.hasNextLine()){
             String oneLine = read.nextLine();
             String[] parts = oneLine.split(",");
             try {
                 date = parts[0];
                 name = parts[1];
                 description = parts[2];
                 amount = Double.parseDouble(parts[3]);
                 System.out.printf("%15s%15s%15s%20s%n", "---------------", "---------------",
                         "---------------", "---------------------");
                 System.out.printf("%15s%15s%15s%31s%n","Date", "Name", "Description","Amount");
                 System.out.printf("%15s%14s%33s%15s%n",date,name,description,amount);
                 System.out.printf("%15s%15s%15s%20s%n", "---------------", "---------------",
                         "---------------", "---------------------");
             }catch (Exception e){
                 System.out.println("no");
             }
         }

         read.close();
     }catch (Exception e){
         System.out.println("The file could not be found");
     }
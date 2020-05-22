public static void main(String[] args) throws FileNotFoundException, IOException
  {
      Scanner scan = new Scanner(new File("C:\\Personal_Info.csv"));
      int fileNumber = 0;
      String csv = "CSV";
      BufferedWriter writer = null;

      while (scan.hasNextLine())
      {
          String line = scan.nextLine();
          if(line.contains("*File"))
          {
              fileNumber++;
              //check and make sure we close our previous writer
              if(writer != null)
                  writer.close();

              System.out.println("Creating a new file called: " + csv + fileNumber);
              writer = new BufferedWriter(new FileWriter("C:\\" + csv + fileNumber));
          }
          else if(writer != null)
          {
              writer.write(line + "\n");
          }
      }
      System.out.println("\n*************Process Complete*************");
      //Close the scanner 
      scan.close();
      if(writer != null)
          writer.close();
  }
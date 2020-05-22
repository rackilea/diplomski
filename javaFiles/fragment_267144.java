public void to_Array(File example)
{// Now rows and cols will have proper values assigned
String[][] filetable = new String[rows][cols];
     try 
    {
         FileReader file = new FileReader(example);
         Scanner sc = new Scanner(file);

         int r = 0;
         while(sc.hasNextLine())
         {
             String[] tokens = sc.nextLine().split(",");
             for(int c = 0; c < cols; c++)
               {filetable[r][c] = tokens[c];}

             r++;
         }

    }

            catch (FileNotFoundException e) 
    {
        System.out.println(e);
    }
}
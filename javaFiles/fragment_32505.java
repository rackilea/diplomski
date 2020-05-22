public void writeStars() throws IOException
{
    File testStars = new File ("stars.txt");
    BufferedWriter outStars = new BufferedWriter(new FileWriter(testStars, true));
    SaleReader reader = new SaleReader();

     try
    {
        List<Sales> sale = reader.readSale("out1.txt");   
        for (Sales s : sale)
        {
            if(s.computeSales()>= 8000)
            {
            outStars.write(s);
            outStars.newLine();

            }
        }
        outStars.close();

    }catch (IOException ex) {
        Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
    }
}
@Override
    public String toString()
    {
      String output = "";
      for(Bin b : myBins)
      {
          System.out.print(b.toString());
          if(!b.getContents().isEmpty())
          {
            for(BinItem bi : b.getContents())
            {
                System.out.println(findSKU(bi.getSKU()) + ", " + bi.toString());
            }
          }
      }
      return " ";
    }   
    private String findSKU(String SKU)
    {
        for(Footwear f : myCatalog)
        {
            if(SKU.equals(f.getSKU()))
                return f.toString();
        }
        return "";
    }
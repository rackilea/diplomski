double lat1=12.2345673;
     double lat2=12.2345672;
     double dif=lat1-lat2;

     DecimalFormat df = new DecimalFormat("###.#######");
     System.out.println("Diff Val  : "+df.format(dif));
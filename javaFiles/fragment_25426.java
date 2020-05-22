@SuppressWarnings("resource")
        Scanner s= new Scanner(new File("src/inputs.txt")).useDelimiter("\\s+");

        ArrayList<Long> itr= new ArrayList<Long>();
        ArrayList<Double> dub = new ArrayList<Double>();
        ArrayList<String> str = new ArrayList<String>();

        while(s.hasNext())
        {
            if(s.hasNextLong()){
                 itr.add(s.nextLong());
            }
            else if(s.hasNextDouble()){
                 dub.add(s.nextDouble());
            }
            else{
                 str.add(s.next());
             }  
        }
        s.close();
 System.out.println("Long values are ::" + itr);
 System.out.println("Double values are ::" + dub);     
 System.out.println("String Values are" + str);
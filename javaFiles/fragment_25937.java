Map<String,String> mapp = new TreeMap<String,String>(new Comparator<String>(){
        @Override
        public int compare(String paramT1, String paramT2) {
            Integer t1 = paramT1.length();
            Integer t2 = paramT2.length();
            return t2.compareTo(t1);
        }

    });
     mapp.put("ab","blue");
     mapp.put("abc","black");
     mapp.put("abcdef","green");
     mapp.put("abcd","pink");

     for(String t : mapp.keySet()){
         System.out.println(" key :"+ t);
     }
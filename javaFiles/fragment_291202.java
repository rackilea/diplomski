for(String s: finalmapWin8.keySet()){
        System.out.println(s + " : ");
        for(Entry<String, String> entry : finalmapWin8.get(s).entrySet()){
           System.out.println(entry);
        }
    }
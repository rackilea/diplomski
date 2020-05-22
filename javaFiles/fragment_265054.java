public ArrayList<String> returnArray()throws FileNotFoundException
     {
        private ArrayList<String> list = new ArrayList<String>();

        Scanner scanCharacters = new Scanner(file);
        String temp = "";

        while (scanCharacters.hasNext())
        {
            temp+=scanCharacters.next();
        }

        while(temp.length() > 2){
               list.add(temp.substring(0,3));
               temp = temp.substring(3);
            }
            if(temp.length()>0){
            list.add(temp);
            }



        scanCharacters.close();

        return list;
    }
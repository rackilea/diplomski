public static void stutter(ArrayList<String> list, int repeat){
    ArrayList<String> modifiedList = new ArrayList<String>();
    for(String str : list) {
        for(int i = 0; i < repeat; i++)
            modifiedList.add(str);
    }       
    System.out.print(modifiedList);
 }
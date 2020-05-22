public int[] parseXYCoord(String s) {
    String master=s;
    if(s.contains(",")){
        master=master.replace("(","").replace(")","");
        master=master.replace(","," ");
    }else if(master.matches("^[a-z]((\\s[0-8])|[0-8])$")){
        int charValue=master.charAt(0)-'a'+1;
        master=charValue+" "+master.charAt(master.contains(" ")?2:1);


    }
    return parseMaster(master);
}

private int[] parseMaster(String master) {
    if(!master.matches("^[0-8] [0-8]$"))
        throw new IllegalArgumentException("Inputted Number is incorrect!");
    String[] splitMaster=master.split(" ");
    return new int[]{Integer.parseInt(splitMaster[0]),Integer.parseInt(splitMaster[1])};

}
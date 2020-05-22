static ArrayList<String> word=Reading();

public static  ArrayList<String> FindWord(){
    ArrayList<String> rewrite=new ArrayList<>();
    String userinput = "" ;
    while (true) {
        userinput=Chat();
        if (userinput.equals("quit")) break;
        for(String elmt:word){
            if (elmt.startsWith(userinput) && elmt.contains("=")) {
                String[] parts=elmt.split("\\=");
                rewrite.add(parts[1]);
            }
    }
   System.out.println(rewrite);
   return rewrite;  // RETURNS THE SYNONIM OF THE WORD
}
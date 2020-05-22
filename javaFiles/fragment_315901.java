String[] html = new String[] { 
    "<div id=\"option1\">hello</div>",
    "<div style=\"color: cyan\">world</div>" };

for(String index : html){
    int firstEnd = index.firstIndexOf("/>");
    int lastBeginning = index.indexOf("<", 2); // Could become "</div>

    String contents = index.substring(firstEnd + 1, lastBeginning - 1);
    System.out.println(contents);
}
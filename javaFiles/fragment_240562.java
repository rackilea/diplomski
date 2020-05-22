public static void main(String []args){        
    String query1 = "cat";
    String[] text1 = {
        "Cat",
        "caT toy",
        "This is a CaT",
        "caTty",
        "loCation"
    };
    for(String s : text1){
        System.out.println("Query -> " + query1 + "\nText -> " + s + "\n" + find_match(query1, s) + "\n");
    }
    String query2 = "luke j";
    String query3 = "lukej";
    String[] text2 = {
        "Luke Johnson",
        "lukejohnson",
        "Luke      Johson",
        "This is Luke  Johnson",
        "L ukeJohnson",
        "L uke Johnson"
    };
    for(String s : text2){
        System.out.println("Query -> " + query2 + "\nText -> " + s + "\n" + find_match(query2, s));
        System.out.println("Query -> " + query3 + "\nText -> " + s + "\n" + find_match(query3, s) + "\n");
    }    
 }
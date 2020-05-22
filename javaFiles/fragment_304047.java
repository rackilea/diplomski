public static void read_doc_word(String line){             
    String doc_id = "" ;
    String word_id = "" ;
    String[] split ;

    split = line.split("\\t");

    if(split.length==2){
        doc_id = split[0];
        word_id = split[1];
    }

    System.out.println("doc id " + doc_id ) ; \\ 1
    System.out.println("word id " + word_id ) ; \\29

}
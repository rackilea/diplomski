public static void main(String[] args) {
    String text = "This is a sample text. Simple yet elegant. Everyone dies. I don't care. This text is nice.";
    String[] words = new String[] {"text", "care", "nice"};
    String[] parts = text.split("\\.");

    for(String w: words){
        for(String sentence: parts){
            if(sentence.contains(w)){
                System.out.println(sentence +" //contains: "+w);
            }
        }
    }   
}
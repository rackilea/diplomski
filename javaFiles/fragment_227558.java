public static void main(String[] args) {
    // TODO Auto-generated method stub
    ArrayList<String> input_words = new ArrayList<String>();
    input_words.add("SCHOOLWORK");
    input_words.add("BALCONY");
    input_words.add("INSIST");
    input_words.add("SALTPETER");
    input_words.add("BOLTON");
    input_words.add("KITSCHY");
    input_words.add("CLIENTELE");
    System.out.print(getTiles(input_words),DEFAULT_SPLITTER); //Make sure to use DEFAULT_SPLITTER
}
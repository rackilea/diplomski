public static void main(String[] args) {
        String text = "THIS IS A SAMPLE TEXT";
        String[] separated = text.split(" ");//separates by spaces 

            if (text.isEmpty()) {
                System.out.println("empty text");
            } else {
                for (Integer position = 0; position < separated.length; position++) {

                    System.out.println(separated[position]);
                }
            }
            int WordCount = separated.length;
            System.out.println("number of words: " + WordCount);
    }
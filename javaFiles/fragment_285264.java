public static void main(String[] args) {
        String text = "Hello worlld this is someething cool!";
        //add # between all double letters
        String processingOfText = text.replaceAll("(\\w)\\1", "$1#$1");
        System.out.println(processingOfText);

    }
public static void main(String[] args) {
        String text = "Hello worlld this is someething cool!";
        for (int i = 1; i < text.length(); i++) 
        {
            if (text.charAt(i) == text.charAt(i - 1)) 
            {
                text = text.substring(0, i) + "#" + text.substring(i, text.length());
            }
        }
        System.out.println(text);

    }
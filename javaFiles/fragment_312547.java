public String toUpperCase(String str)
    {
        String t = "";
        for (int i = 0; i < str.length(); i++){
            char a = str.charAt(i);
            char b = Character.toUpperCase(a);
            t += Character.toString(b);
        }
        return t;
    }
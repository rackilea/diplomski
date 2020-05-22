String s = "camel case word";
        String camelCaseSentence = "";
        String[] words = s.split(" ");
        for(String w:words){
            camelCaseSentence += w.substring(0,1).toUpperCase() + w.substring(1) + " ";

        }
        camelCaseSentence = camelCaseSentence.substring(0, camelCaseSentence.length()-1);
        System.out.println(camelCaseSentence);
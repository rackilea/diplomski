public static String nextWord()
    {   
        if ( keyboard.hasNext() == false )
            return null;
        else {   
            String start =  keyboard.next().toLowerCase() ;
            String organized = "";
            for (int i =0; i < start.length(); i++) {
                if (Character.isLetter(start.charAt(i)) == true)
                    organized = organized + start.charAt(i);

                else if (start.charAt(i) == '\'' )
                    organized = organized + start.charAt(i);

                else if (start.charAt(i) == '-')
                    organized = organized + start.charAt(i);
            }
            return organized;       
        }   
    }
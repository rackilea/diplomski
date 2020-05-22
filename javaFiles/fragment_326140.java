String s = "";
        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length; i++) 
        {
            switch (words[i]) 
            {
            case  "+" :
                lex_air[0]++;
                break;

            case  "-":
                lex_air[1]++;
                break;

            case  "*" : 
                lex_air[2]++;
                break;

            case  "/":
                lex_air[3]++;
                break;

            case  ">":
                lex_log[0]++;
                break;

            case  "<":
                lex_log[1]++;
                break;

            case  "=":
                lex_log[2]++;
                break;

            case  ">=":
                lex_log[3]++;
                break;

            case  "<=":
                lex_log[4]++;
                break;

            case  "for":
                lex_reserve[0]++;
                break;

            case  "int":
                lex_reserve[1]++;
                break;

            case  "while":
                lex_reserve[2]++;
                break;

            case  "char":
                lex_reserve[3]++;
                break;

            default:
                lex_alpha++;
                break;

            }
        }
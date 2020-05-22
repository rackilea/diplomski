for (String retval: string1.split(" ")){
          if(!retval.matches("[a-zA-Z]+")){
                  String a="Not a String Please try again ^_^";
                  JOptionPane.showMessageDialog(null,a,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
           for (int i = 0; i < retval.length(); i++)
            {
                    char ch = retval.charAt(i);
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    {
                            vowels++;
                    } else 
                    { 
                            consonants++;
                    }

            }
    }
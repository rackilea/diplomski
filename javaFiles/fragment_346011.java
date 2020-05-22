String dictLowercase = new String("abcdefghijklmnopqrstuvwxyz");
        String dictUppercase = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        char[] dictLowerArray = dictLowercase.toCharArray();//Use toCharArray
        char[] dictUpperArray = dictUppercase.toCharArray();
        char[] inputLetters = input.toCharArray();
        char[] output=new char[inputLetters.length];
        for(int i=0;i<inputLetters.length;i++){
            for(int c=0;c<25;c++){
                if (inputLetters[i]==(dictLowerArray[c])){
                    output[i] = (char) (dictLowerArray[c]+Key % 26);//Logic Issue
                }
                else if (inputLetters[i]==(dictUpperArray[c])){
                    output[i] = (char) (dictUpperArray[c]+Key % 26);
                }
                else {
                      output[i] = inputLetters[i];//If not alphabets
                }                
            }
          }
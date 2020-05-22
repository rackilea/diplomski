boolean hasDivisor = false;

for (int i = 0; i < NumBox.length; i++) 
            {
             if (NumBox[i] == 0) 
                continue;
             hasDivisor = false;
             for (int j = 0; j < i; j++) {

                if (NumBox[j] == 0) 
                 continue;
                 if (NumBox[i] % NumBox[j] == 0) {
                   hasDivisor = true;
                   break;
                }
             }
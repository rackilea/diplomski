String aStr = "gallery|settings|À ";

                 char[] charArray = aStr.toCharArray();

                 for(int i = 0; i < charArray.length; i++){

                     int x = Character.codePointAt(charArray, i);
                     Log.e(TAG, "x = " + x);
                 }

x = 103
x = 97
x = 108
x = 108
x = 101
x = 114
x = 121
x = 124
x = 115
x = 101
x = 116
x = 116
x = 105
x = 110
x = 103
x = 115
x = 124
x = 192   //À
x = 32
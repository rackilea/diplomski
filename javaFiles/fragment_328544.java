try {
     str = URLEncoder.encode("t_id=636207115 :#=1:price=1,18|it_id=636207115 :#=1:price=1,18|it_id=636205395 :#=1:price=0,92", "UTF-8");
    } 
 catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

String abc[] = str.split("%7C"); // %7C is Encoded | by which you want to spilt the String

// Loop Through the Array and Decode the String !


for (int i = 0; i < abc.length; i++) {
    try {
         abc[i] = URLDecoder.decode(abc[i], "UTF-8");// Decoding String and Stroring it back to Array
         System.out.println(abc[i]);// Testing String 
        } catch (UnsupportedEncodingException e) {
          // TODO Auto-generated catch block
            e.printStackTrace();
        }
 }
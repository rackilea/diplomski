public static void combin(String input,StringBuffer output,int depth){
      if (depth == 0) {
            System.out.println(output);
        } else {
            for (int i = 0; i < input.length(); i++) {
                output.append(input.charAt(i));
                combin(input, output,depth - 1);
                output.deleteCharAt(output.length() - 1);
            }
        }    
 }
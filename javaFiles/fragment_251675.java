final String input = "some string . ";
    final StringBuffer sb = new StringBuffer();
    final String permittedCharacters = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    for (char c : input.toCharArray()){
        if (permittedCharacters.indexOf(c)>=0){
            sb.append(c);
        }
    }
    final String endString = sb.toString();
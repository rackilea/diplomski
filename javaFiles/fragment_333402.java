String tempString = sb.toString().substring(1); // Remove first colon
    System.out.println("\nInitial string before splitting = " + tempString);

    String[] tok = tempString.split("\n:"); //  Split by new line and colon
    System.out.println("\ntok.length = " + tok.length);
    System.out.println("\nArray after splitting of initial string = " + Arrays.toString(tok));

    for(String string:tok){
        System.out.println("\nStarting to match values for string = " + string);
        if(string.contains(":")){
            int last=string.lastIndexOf(':');
            String tag=string.substring(0,last);
            String[] data=string.substring(last+1).split("\n");

            System.out.println("tag = " + tag + ", data = " + Arrays.toString(data));
        }else{
            System.out.println("String \"" + string + "\" does not contain ':' character.");
        }
    }
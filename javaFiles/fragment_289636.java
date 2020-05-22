public static void main (String[] args){

    do{
        try{
            System.out.println("Waiting for instructions: ");
            instructions= input.nextLine();
        String preparsedInstructions = instructions;
        int from = instructions.indexOf(" ");
        if(from > -1){
            int to = preparsedInstructions.indexOf(" ", from + 1);
            if(to > -1){
                preparsedInstructions = preparsedInstructions.substring(0, to);
            }
        }

            switch (preparsedInstructions){
                case "create client":
                    createClient();
                    break;
                case "create music":
                    createMusic();
                    break;
                case "create selling":
                    //createSelling();
                    break;

                case "list client":
                    listClient();
                    break;
                case "list music":
                    listMusic();
                    break;
                case "list selling":
                    //listSelling();
                    break;
                case "erase client":
            if (instructions.length() <= 18 && instructions.length() >= 17 && instructions.substring(0, 16).equals("erase client")){
                String client_code = instructions.substring(16);
                client_code = client_code.trim();
                int code = Integer.parseInt(client_code);
                eraseClientWithCode(code);
            }else{
                    eraseClientWithoutCode();
            }
                    break;
        ...//do for erase music,selling

        default: //error handling
            }
        }catch (NullPointerException npe){
            System.out.println("There are not articles on the list");
        }



    }while(!instructions.equals("close"));
}
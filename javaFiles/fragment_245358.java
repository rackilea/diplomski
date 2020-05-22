//Move remaining response bytes into string
        String answers = "";
        try {
            while(true) {
                rest = DataIS.readUnsignedByte() + "";
                answers += Integer.parseInt(rest, 10) + " ";
            }
        }
        catch(EOFException ignore) {}
        String[] answersArray = answers.split(" ");

        //Initialize IPAddresses array
        String IPAddresses[] = new String[Response.NumAnswers];
        for(int i=0; i<Response.NumAnswers; i++)
            IPAddresses[i] = "";

        int offset = 12;
        for(int i=0; i<Response.NumAnswers; i++) {


            int j=0;
            while(j++<3) 
                IPAddresses[i] += answersArray[offset+j] + ".";
            IPAddresses[i] += answersArray[offset+j] + "";
            offset += 16;
        }
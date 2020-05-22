for(int x = 0; x == setKey.length; x++){
        char input;
        do{
            input = Character.toUpperCase(keyScan.next().charAt(0));
            }while(input < 'A' || input >'D');
        // store answer
        setKey[x] = input;
    }
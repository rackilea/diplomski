while (!sentenceInput.equals ("STOP")) {
    if (sentencePunct == '?') 
    { 
        if (remainder == 0) {
            System.out.println("Yes");`
            System.out.println("Please Input another sentence (terminate with \"STOP \")");
            sentenceInput= myScanner.nextLine(); 
        }
        else {
            System.out.println("No");
            System.out.println("Please Input another sentence (terminate with \"STOP \")");
            sentenceInput= myScanner.nextLine(); 
        }
    } 
    else if (sentencePunct == '!') {
            System.out.println("Wow!");
            System.out.println("Please Input another sentence (terminate with \"STOP \")");
            sentenceInput= myScanner.nextLine(); 
        }
        else {
            System.out.println("You always say " + sentenceInput);
            System.out.println("Please Input another sentence (terminate with \"STOP \")");
            sentenceInput= myScanner.nextLine(); 
        }
    }
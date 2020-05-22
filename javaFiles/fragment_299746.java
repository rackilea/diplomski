for(String arg: args) {
        // Convert each String arg to char array
        caMainArg = arg.toCharArray();

        // Convert each char array to String
        strMainArg = new String(caMainArg);
        System.out.print(strMainArg + " - " + strMainArg.length());

        if(regExVowels.matches(strMainArg)) {
            System.out.print(" - vowel");

        } else if(regExUpperConsonants.matches(strMainArg) ||

        ....

    }
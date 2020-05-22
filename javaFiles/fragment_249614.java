inputInt=keyboard.nextInt();
        for(int i =0;i<inputStr.length();i+=inputInt){     
            if(i+inputInt < inputStr.length())
                System.out.println(inputStr.substring(i,i+inputInt));

        }
private String[] makeOptions(int correctAns) {

        String [] ansStrins = new String[4];
//        for (int i=0;i<ansStrins.length;i++){
//            System.out.println("Option "+i+ ": "+ansStrins[i]);
//
//        }
        int randomPos = (new Random().nextInt())%4;
        ansStrins[randomPos]=correctAns+"";
        for (int i=0;i<4;i++){
            int randomAns = (int)(Math.random() * 10 + Math.random() * 10);
           if(ansStrins[i]==null){
               ansStrins[i]=randomAns+"";
           }
        }
        return ansStrins;
    }
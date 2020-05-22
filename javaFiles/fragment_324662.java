}
        if(prediction.equals("h") && toss==0){
            System.out.print(" You win.");
            wins ++;
        }else if(prediction.equals("h") && toss !=0){
            System.out.print(" You loose.");
        }else if(prediction.equals("t") && toss==1){
            System.out.print(" You win.");
            wins++;
        }else if(prediction.equals("t") && toss!=1){
            System.out.print(" You loose.");
        }
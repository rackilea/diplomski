for (int i = 1; i<=length; i++) {
        for (int j = 0; j < a.length; j++) {
            if(i==a[j]){
             isExit =true;
             break;
            }
        }
        if (!isExit) {
            System.out.println(i);
            //break;
        }
        isExit = false;
    }
int stay = 0;
    while(stay == 0){
        int e;
        int f = 0;
        for(e = 1; e <= posInt; e++){
            if((q + 1) == Prime[f]){
                stay++;
                break;
            }
            f++;
            System.out.println("Infinite");
        }
        q++;
    }
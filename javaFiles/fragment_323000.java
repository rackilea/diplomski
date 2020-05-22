public static int[] shots(int num){
        int[] shots = new int[num];
        for(int i = 0; i<num;i++){
        System.out.println("How many coffee shots in cup "+(i+1)+" ?");
        shots[i] = keyboard.nextInt();  
        }
        return shots;
    }
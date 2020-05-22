for(int i: number1) {
        for(int j: numbers2) {
            if(i == j) {
                System.out.println(i);
                break; //exit the inner loop if the number is present
            }
        }
    }
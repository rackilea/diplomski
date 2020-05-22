public void palindrome(){
    int n=0,largest=0;
    for (int i = 100; i <= 999; i++) { // I belive that largest palindrome is between 100 and 999
        for (int j = i+1; j <=999; j++) {
            n=i*j;
            if(n>100000){
                if(n/100000==n%10){//first and last
                    if((n/10000)%10==(n%100)/10){ //second and fifth
                        if((n/1000)%10==(n%1000)/100){ //third and fourth
                            if(n>largest) largest=n;

                        }
                    }
                }
            }
        } 
    }
    System.out.println(largest);
}
for(int i = 2; i < x; i++) {
    if(x % i == 0) {   
        int count = 0;
        for(int j = 1; j <= i; j++)
            if(i%j == 0)
                count++;
        if(count == 2)
            product *= i;
    }
}
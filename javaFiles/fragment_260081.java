public static int F(int n){
    if (n > 1){             // ***** Opening brace 1
        if (n%2 == 0){
            n = n/2;
            System.out.println(n);
            return F(n);
        } else if(n%2 != 0){  // ***** Opening brace 2
            n = 3*n+1;
            System.out.println(n);
            return F(n);
        }            // This curly brace matches "opening brace 2"
    }                // This curly brace matches "opening brace 1"
    else {
        System.out.println("Complete");
        return 0;
    }
}
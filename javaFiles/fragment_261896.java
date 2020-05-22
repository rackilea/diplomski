while(true) {
        if(n!=42) {
            n = input.nextInt();   // Number is read here
            System.out.println(n); // and unconditionally (always) printed here, 42 or not
        }
        else{
            break; // At next iteration, if last number read was 42
                   // you break out of the "while" loop
        }
    }
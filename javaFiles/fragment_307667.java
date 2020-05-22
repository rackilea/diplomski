do{

        fn = f0 + f1;
        System.out.println("Fibonnaci-tall " + i + " = " + f0);
        f0 = f1;
        f1 = fn;
        i++;

}while(f0<=number);
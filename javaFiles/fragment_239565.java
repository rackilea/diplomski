while(m1.find()){
    result = Integer.parseInt(m1.group());

    //result not prime
    if( !(result % 2 == 0) ){
        System.out.println(result);
    }
}
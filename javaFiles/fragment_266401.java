for(int i = 1; i < 101; i= i +1 ){
    if (i%15 == 0){
        System.out.println("ÒFizzBuzzÓ");
    }else if (i % 3 == 0){
        System.out.println("ÒBuzzÓ");
    }else if (i % 5 == 0){
        System.out.println("ÒFizzÓ");
    } else {
        System.out.println(i);
    }
}
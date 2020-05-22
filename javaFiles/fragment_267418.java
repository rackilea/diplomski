int count;
    for(count = 1; count <= 99;count++){
    if(count%3==0 && count%5==0 ){
        System.out.print( "tigh, ");
    }
    else if(count%5==0 ){
        System.out.print( "high, ");
    }
    else if(count%3==0 ){
        System.out.print( "tree, ");
    }
    else{
        System.out.print( count+", ");  
    }


    }
    System.out.print(100);
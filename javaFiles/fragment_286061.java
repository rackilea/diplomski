try{

    DoubleArraySeq x = new DoubleArraySeq();
    System.out.println("sequence x is empty");
    x.print();
    System.out.println("Trying to get anything from x causes an exception\n");
    System.out.printf("%5.2f", x.getCurrent());
}catch(IllegalStateException e){
    System.err.println("This exception produce because there is no element");
}
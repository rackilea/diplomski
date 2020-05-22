Outer outObj = new Outer();
    Outer.Inner inObj = outObj.new Inner();

    // Using Reflection
    Class objTyp = inObj.getClass();
    System.out.println(objTyp.getName());

    //  >>>>> objTyp is already inObj.getClass() <<<<<<
    if(objTyp.getClass() == Outer.Inner.class){
        System.out.println("Match classes!");
    }else{
        System.out.println("Mismatch classes!");
    }
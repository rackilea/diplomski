public boolean checkFinger() throws Exception {
    //Boolean thereIsFinger = Boolean.FALSE; //original line
    Boolean thereIsFinger = Boolean.TRUE;   //solution
    //bsp is a JNI Library 
    bsp.CheckFinger(thereIsFinger);
    return thereIsFinger;
}
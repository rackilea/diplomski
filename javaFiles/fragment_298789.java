for(int i=1; i<=x1.asInteger(); i++){
    for(int j=1; j<=x2.asInteger(); j++){
                     REXP cls1 = instance.eval("c1 <- h["+i+","+j+"]");
                     System.out.println(cls1.asString());
    }
}
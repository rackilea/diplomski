public void hi(int x) {
    if (x == Integer.MIN_VALUE) {
        String newParam = getTheParamFromProxySomehow();
        hi(newParam);
        return;
    }    
    System.out.println("hi: " + x);
}
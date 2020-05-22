Random random = new Random();
while(true){
    try {
        X.class.getDeclaredMethod(toBinaryString(random.nextLong()));
    } catch (Exception e) {
    }
}
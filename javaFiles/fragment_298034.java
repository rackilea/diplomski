public static char checkInt() {
    Random rand1 = new Random(); 
    int value = rand1.nextInt(100); 
    if (value >= 65) {
        // Note that these are single quotes because it's a char, not a String
        return '#';
    }   else {
        return '.';
    }
}
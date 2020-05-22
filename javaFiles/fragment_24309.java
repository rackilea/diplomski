private LargeNumber makeLargeNumber(String line) {
    LargeNumber num1 = new LargeNumber();
    String numbers[] = oneLine.split(",");
    s = 0;
    for(int i = 0; i < numbers.length; i++){
        num1.push(Integer.parseInt(numbers[i]));
    }
    return num1;
}
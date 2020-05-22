public void countDigits(int num) {      
    int count=0;
    String numF = String.valueOf(num);

    for (int j = 0; j <= 9; j++) {
        count=0;
        for (i = 0; i <numF.length(); i++) {
            char c = numF.charAt(i);
            String number=String.valueOf(j);
            if (c == number.charAt(0)) {
                count++;
            }
        }
        System.out.println("The number " + j + " appaeared " + count + " times in 347213");

    }
}
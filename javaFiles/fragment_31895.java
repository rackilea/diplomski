int j = 0;
for (int i = 0; i < dataArr.size(); i++) {
    String[] phoneData = dataArr.get(i);
    if (phoneData[1].equals(phone)) { // i am assuming here that the phone number is the 2nd element of the String[] array, since i dont know how the textfile looks.
        System.out.println("Found number.");
        club[j++] = phoneData[1];
    } else if (i == dataArr.size()-1) {
        System.out.println("Didn't find number.");
    }
}
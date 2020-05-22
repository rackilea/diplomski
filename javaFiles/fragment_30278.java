int wordToGet = rnd.nextInt(8); // returns 0-7
while ((str = inputCurrent.readLine()) != null) {
    if (wordToGet == 0)
        break; // found word
    wordToGet--;
}
System.out.println(str); // prints null if file didn't have enough words
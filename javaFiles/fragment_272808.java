int ISBN, r, i;
String st;

Scanner keyboard;
keyboard = new Scanner(System.in);

System.out.println("Please enter the first 9 digits of your ISBN number:");
ISBN = keyboard.nextInt();

st = String.format("%09d", ISBN); // fixes your 0-bug.

if (st.length() == 9){
    r = ((st.charAt(0) - '0') * 1 // fixes your computation bug.
       + (st.charAt(1) - '0') * 2
       + (st.charAt(2) - '0') * 3
       + (st.charAt(3) - '0') * 4
       + (st.charAt(4) - '0') * 5
       + (st.charAt(5) - '0') * 6
       + (st.charAt(6) - '0') * 7
       + (st.charAt(7) - '0') * 8
       + (st.charAt(8) - '0') * 9);

    if (r % 11 == 10){
        System.out.println("Your ISBN Number is: " + ISBN + "X");
    }
    else {
        System.out.println(st);
        i = (ISBN * 10) + (r % 11);
        System.out.println("Your ISBN Number is: " + i);
    }

}
else {
    System.out.println("This is an invalid ISBN entry!");
}
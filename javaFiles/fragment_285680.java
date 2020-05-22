String num;
Scanner sl = new Scanner(System.in);
num = sl.next();
if (num.matches("[01]+") && !num.startsWith("0")) {
    System.out.println("Correct number :" + num);
}else{
    System.out.println("Not Correct number!");
}
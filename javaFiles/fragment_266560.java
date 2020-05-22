Scanner keyboard = new Scanner(System.in);
System.out.print("Please type your invoice number: ");
setInNum(keyboard.nextInt());
System.out.print("What month is the balance due?(Choose from 1-12) ");
setM(keyboard.nextInt());
System.out.print("What day is the balance due?(Choose from 1-31) ");
setD(keyboard.nextInt());
System.out.print("What year is the balance due? (Choose from 2011-2017) ");
setY(keyboard.nextInt());

System.out.println("Your invoice number is " + getInNum() +  " and your balance due is on " + getM() + "/" + getD() + "/" + getYy() + ".");
public static void main(String[] args) {    
    Calendar c; 
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Scanner input = new Scanner (System.in);
    try {
        do{
            System.out.println("Enter the day in number:");
            int day1= input.nextInt();

            //Enter the Month
            System.out.println("Enter the Month in number");
            int month= input.nextInt( );

            //Enter the Year
            System.out.println("Enter the Year in number format");
            int year= input.nextInt( );
            Date date = formatter.parse((String.format("%d/%d/%d",day1,month,year)));
            System.out.println(date);
            c= Calendar.getInstance();
            c.setTime(date);
            int day =  c.get(Calendar.DAY_OF_WEEK);
            if (day == Calendar.SUNDAY) {
                System.out.println("Sunday");
            }
            else if (day == Calendar.MONDAY) {
                System.out.println("Monday");
            }
            else if (day == Calendar.TUESDAY) {
                    System.out.println("Tuesday");
            }
            else if (day == Calendar.WEDNESDAY) {
                        System.out.println("Wednesday");
            }
            else if (day == Calendar.THURSDAY) {
                System.out.println("Thursday");
            }
            else if (day == Calendar.FRIDAY) {
                System.out.println("Friday");
            }
            else if (day == Calendar.SATURDAY) {
                System.out.println("Saturday");
            }
            System.out.println("To exit press CTRL+Z(Windows) or CTRL+D(LINUX), or any key to continue");
            input.nextLine();
        }while (input.hasNextLine());

    }catch(NoSuchElementException n){
        System.out.println("NoSuchElementException");
    }catch(ParseException pe){
        System.out.println("invalid date");
    }finally {
        input.close();
        System.out.println("exiting");
    }   
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BroDoYouEvenAge {

    // add in try-catch statements x
    // only numeric values x
    // leap year
    // loop if invalid
    // loop if day is invalid
    // less than 1 or greater than max day x
    // add in no spaces or letters x

    // VALIDATION FOR MONTHS x
    // loop if invalid
    // same year x

    // try again x
    // loop if invalid

    static int cDay;
    static int cMonth;
    static int bYear;
    static int bMonth;
    static int bDay;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        prompt();
        retry();
    }

    public static void prompt() {
        BufferedReader delta = new BufferedReader(new InputStreamReader(System.in));
        try {

            System.out.println("Please enter the current year");
            String Year = delta.readLine();
            int cYear = Integer.parseInt(Year);

            // prompts the user for the current month as a numeric value
            boolean validmonth = false;
            while(!validmonth) {
                System.out.println("Please enter the current month as a numeric value");
                String Month = delta.readLine();
                cMonth = Integer.parseInt(Month);

                if(cMonth < 1 || cMonth > 12) {
                    System.out.println("Your input was invalid");
                } else {
                    validmonth = true;
                }
            }

            // prompts the user for the current day as a numeric value
            boolean validday = false;

            while(!validday) {
                System.out.println("Please enter the current day as a numeric value");
                String Day = delta.readLine();
                cDay = Integer.parseInt(Day);

                if(cDay < 1) {
                    System.out.println("Your input was invalid");
                } else if(cDay > 31) {
                    System.out.println("Your input was invalid");
                } else if(cMonth == 4 && cDay > 30) {
                    System.out.println("Your answer is invalid");
                } else if(cMonth == 6 && cDay > 30) {
                    System.out.println("Your answer is invalid");
                } else if(cMonth == 9 && cDay > 30) {
                    System.out.println("Your answer is invalid");
                } else if(cMonth == 11 && cDay > 30) {
                    System.out.println("Your answer is invalid");
                } else {
                    validday = true;
                }
            }

            // prompts the user for their birth year
            boolean validYear = false;
            while(!validYear) {
                System.out.println("Please enter your birth year");
                String Year2 = delta.readLine();
                bYear = Integer.parseInt(Year2);

                if(bYear > cYear) {
                    System.out.println("Your answer was invalid");
                } else {
                    validYear = true;
                }
            }
            // does not allow user to input a value greater than their current
            // year
            // loops if invalid

            // prompts the user for their birth month
            boolean _validmonth = false;
            while(!_validmonth) {
                System.out.println("Please enter your birth month as a numeric value");
                String Month2 = delta.readLine();
                bMonth = Integer.parseInt(Month2);

                if(bMonth < 1 || bMonth > 12) {
                    System.out.println("Your answer was invalid");
                } else {
                    _validmonth = true;
                }
            }

            // prompts the user for their birth day
            boolean _validday = false;
            while(!_validday) {
                System.out.println("Please enter the day you were born as a numeric value");
                String Day2 = delta.readLine();
                bDay = Integer.parseInt(Day2);
                // prints out collected data

                if(bMonth == 4 && bDay > 30) {
                    System.out.println("Your answer is invalid");
                } else if(bMonth == 6 && bDay > 30) {
                    System.out.println("Your answer is invalid");
                } else if(bMonth == 9 && bDay > 30) {
                    System.out.println("Your answer is invalid");
                } else if(bMonth == 11 && bDay > 30) {
                    System.out.println("Your answer is invalid");
                } else {
                    _validday = true;
                }
            }

            System.out.println("The current date is " + cMonth + "/" + cDay + "/" + cYear);
            System.out.println("Your birthday is " + bMonth + "/" + bDay + "/" + bYear);

            // calculates and prints age
            if(cMonth > bMonth) {
                int age = cYear - bYear;
                System.out.println("You are " + age + " years old ");
            } else if(cMonth < bMonth) {
                int age = cYear - bYear;
                System.out.println("You are " + age + " years old ");
            } else if(cMonth == bMonth && cDay > bDay) {
                int age = cYear - bYear;
                System.out.println("You are " + age + " years old.");
            } else if(cMonth == bMonth && cDay < bDay) {
                int age = cYear - bYear - 1;
                System.out.println("You are " + age + " years old. ");
            } else if(cYear == bYear) {
                System.out.println("You are not even a year old.");
            } else {

                System.out.println("Your input was invalid");
            }
        } catch(IOException IOE) {

        } catch(NumberFormatException NFE) {
            System.out.println("Please enter a numeric value without spaces, letters, or special characters");
        }
    }

    public static void retry() {
        BufferedReader delta = new BufferedReader(new InputStreamReader(System.in));

        try {
            boolean valid = false;
            while(!valid) {
                System.out.println("Would you like to try again? 1) Yes or 2) No");
                System.out.println("Please enter a number");
                String retry = delta.readLine();
                int trynum = Integer.parseInt(retry);

                if(trynum < 1 || trynum > 2) {
                    System.out.println("Your input was invalid. Please enter 1 or 2.");
                    continue;
                } else if(trynum == 1) {
                    prompt();
                } else if(trynum == 2) {
                    System.out.println("Okay then.");
                    System.exit(0);
                } else {
                    System.out.println("Invalid");
                    continue;
                }
            }
        } catch(IOException IOE) {

        } catch(NumberFormatException NFE) {
            System.out.println("Please enter a number");
        }
    }
}
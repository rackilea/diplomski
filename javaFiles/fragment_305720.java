public static double getDoubleGreaterThan(double low, Scanner input, String prompt) {
            double num;
            num = getDouble(input,prompt);
                if(num <= low){
                System.out.println("Error! Must be greater than 1");
                num = getDouble(input,prompt);
                }
                    if (num > 100){
                    System.out.println("Error! Must be less than 100");
                    num = getDouble(input,prompt);
                    }


            return num;
        }
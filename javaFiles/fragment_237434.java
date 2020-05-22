public static void main(String[] args) {

        //int max = 0;
        int sum = 0;
        int count = 0;
        int age, maximum=0;
        double average= 0;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("enter age");
            age = sc.nextInt();

            if (age <0||age > 120)
            {
                System.out.println("enter numbers between 1 to 120");
                //age = sc.nextInt();
            }

            else
            {
                count ++;
                sum = sum + age;
                maximum = getMax(maximum, age);
                                }
        }while(age != 0);
        average = getAve(sum, count);
        System.out.println("max is" + maximum + "\naverage is" + average);

    }

    public static int getMax (int max, int age)
    {
        if (max < age)
        {
            max = age;
        }
        return max;
    }

    public static double getAve (int sum, int count)
    {
        double average;
        average = (double)sum / (double)count;
        return average;
    }
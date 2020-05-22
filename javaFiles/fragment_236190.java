public static void main(String[]args)
    {
        Scanner a=new Scanner(System.in);
        ArrayList myList=new ArrayList();
        for(int i= 0; i < 2; i++)
        {
            System.out.print("Enter whole number.Enter x to quit: ");
            if (a.hasNextInt()) {
                int userinput=a.nextInt();
                myList.add(userinput);
            }
            else if (a.next().equals("x")) {
                break;
            }
        }

        System.out.println(myList);
    }
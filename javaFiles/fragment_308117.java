Scanner input = new Scanner(System.in);
    int l;
    while (true)
    {
        l = input.nextInt();
        if ((""+l).indexOf('.') >= 0 || (""+l).indexOf('-') >= 0)
        {
            System.out.println(/*your message here*/);
        }
        else
        {
            break;
        }
    }

//continue with your program
Scanner reader = new Scanner(System.in);
        int numbers[] = new int[100];
        int count=0;
        do
        {
            System.out.print("Enter an integer ('blank' to exit): ");
            String sInput=reader.nextLine();
            char[] cArrInput=sInput.toCharArray();
            if (cArrInput.length>0)
            {
                numbers[count]=cArrInput[0];
                count=count+1;
            }
            else if (sInput.length()==0)
            {
                break;
            }
        }while(count<100);
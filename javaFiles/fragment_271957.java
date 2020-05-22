int score = 0;
        System.out.println("Enter test case:");
        int testCase= Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= testCase; ++i)
        {
            System.out.println("Enter pattern:");
            String str = sc.nextLine();
                for (int j = 0; j < str.length(); j++)
                {
                    if (str.charAt(j) == '0')
                    {
                        score += 1;

                    }
                    else if (str.charAt(j) == 'X')
                    {
                        score += 0;
                    }
                }

                System.out.println(score);

                score = 0; // reset score to zero for the next test case 
        }
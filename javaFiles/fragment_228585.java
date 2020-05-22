void mousePressed() 

    {
        for (int i = 0; i < 5; i++) 
        {
            int temp = generateRandomNumber();
            if (!randomNumberArray.contains(temp)) 
            {
                randomNumberArray.add(temp);
            }
        }
        System.out.println(randomNumberArray);
    }

    public int generateRandomNumber() 
    {
        Random randomNumber = new Random();
        return randomNumber.nextInt(20);
    }
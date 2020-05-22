public seq()
    {
        num = new Random();

        // Do not try to specify size of Array List here. THey don't have fixed size.
        arrListOne = new ArrayList<Integer>();
        arrListTwo = new ArrayList<Integer>();
        getFillerArr();
        randNewArr();
    }

    public void getFilledArr()
    {
        // Manually iterate for 10 elements.
        for(int i = 1; i < 11 ; i++)
        {
            arrListOne.add(i);
        }
    }

    public ArrayList randNewArr()
    {
        for(int i = 0 ; i < 10 ; i++)
        {
        // Do not add +1 here, actual array size is already 1 less than the size you get from #size() method.
        int randNum = num.nextInt(arrListOne.size());
        arrListTwo.add(arrListOne.get(randNum));
        arrListOne.remove(arrListOne.get(randNum));
        }
        return arrListTwo;
    }
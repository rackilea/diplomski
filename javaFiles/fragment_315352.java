@Override
    public String toString()
    {
        int x = (int)(getSize());
        String ShoeInfo = "";
        if (getSize() % x == 0.5)
            ShoeInfo = shoeType + " - " + myStyle + " (size " + x + "\u00bd" + ")";
        else
            ShoeInfo= shoeType + " - " + myStyle + " (size " + x + ")";    
         if (!(getType().equals("Unspecified")))
            return getType() + " - " + ShoeInfo;
         else
            return ShoeInfo;
    }
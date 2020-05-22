private static class Dart{
    int number;
    int amount;
    public Dart(int number, int amount){
        this.number = number;
        this.amount = amount;
    }
    public int value()
    {
        return number * amount;
    }

    public void estimate(int estimate)
    {
        Dart temp = canScore(estimate);
        if(temp != null){
            this.amount = temp.amount;
            this.number = temp.number;
        } else{
            this.number = estimate / 3;
            if(number >= 19)
                this.number = 19;

            this.amount = 3;
        }
    }

    public boolean increment()
    {   
        if(this.amount == 3 && this.number == 20)
            return false;

        if(this.amount == 0)
            this.amount = 1;

        this.number++;
        if(this.number >= 20)
        {
            this.number = 20;
            this.amount++;

            if(this.amount >= 3){
                this.amount = 3;
            }
        }

        return true;
    }

    public String toString()
    {
        return "["+number+","+amount+"]";
    }
}
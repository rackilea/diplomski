//push value on to Stack add value to List of String input variable
    public void push(String anInt)
    {
        aStackArr.add(anInt);
        index = aStackArr.size() - 1;
        System.out.println(index + aStackArr.get(index));
    }
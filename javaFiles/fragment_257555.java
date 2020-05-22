class MyClass
{
    //Variable I want to return
    private int[] numArray = {1, 2, 3};

    public int[] getNumArray() {
        return numArray.clone();
    }
 }
class Test01
{
    int x;
    Test02 test02; //the default value for objects is null you have to instantiate with new operator or pass it as a reference variable

    public Test01(Test02 test02)
    {
        this.test02 = test02; // this case test02 shadows the field variable test02 that is why 'this' is used
        x = test02.x;
    }
}
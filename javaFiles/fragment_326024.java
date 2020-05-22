boolean secondFinished = false;
public int TestData1(String a, String b){
TestdataGeneration td = new TestdataGeneration();

    if("1".equals(a) && "2".equals(b))
    {
        testinput = td.firstdata();
    }
    if("1".equals(a) && "3".equals(b) && !secondFinished)
    {
        testinput = td.seconddata();
        secondFinished = true;
        return testinput;
    }
    if("1".equals(a) && "3".equals(b) && secondFinished)
    {
         testinput = td.thirddata();
    }
    return testinput;
}
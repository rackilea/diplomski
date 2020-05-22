public class Test{
    public static int TestNum = 0;

    public static void setTestNum(int newNum){
        TestNum = newNum;
    }

    public static int getTestNum(){
        return TestNum;
    }

    public static void main(String args[]){
        Test test1 = new Test();
        test1.setTestNum(5);

        Test test2 = new Test();
        System.out.println(test2.TestNum);
    }
}
public class class1 extends class2 {

    class2 testingobj = null;

    /** this is the constructor. It is given a parameter, so it knows 
     *  about the class2
     */
    public class1(class2 frame) {
        this.testingobj = frame;
    }

    private int num = 0;

    public int testing(){
        if(num <=8){
            num ++;
            testingobj.jTextField1.setText("" +num);
        }
        return num;
    }
}
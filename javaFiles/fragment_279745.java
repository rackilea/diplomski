public class Student {

    private String fName;
    private String lName;
    private String stuID;
    private int projM1;
    private int ictM1;
    private int actP1;
    private int codeAsM;
    private int ictM2;
    private int actP2;
    private int ictM3;
    private int actP3;
    private int component1Marks;
    private int component2Marks;
    private int component3Marks;
    private double moduleMarks;

    public Student() {
    }

    .
    .
    .

    @Override
    public String toString() {
        return "Student [fName=" + fName + ", Lname=" + lName + ", studentID=" + stuID + ", marksProject1=" + projM1
                + ", marksICT1=" + ictM1 + ", ActiveP=" + actP1 + ", Code Ass=" + codeAsM + ", ICT2=" + ictM2
                + ", ActiveP2=" + actP2 + ", ICT3=" + ictM3 + ", ActiveP3=" + actP3 + "]";
    }

}
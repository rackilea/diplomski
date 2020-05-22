public class TypeY extends Type {

    public TypeY(int no) {
        this.no = no;
    }

    @Override
    int getNo() {
        System.out.println("TypeY.getNo()");
        return no;
    }
}
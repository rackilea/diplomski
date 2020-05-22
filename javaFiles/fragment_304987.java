public class TypeX extends Type {

    public TypeX(int no) {
        this.no = no;
    }

    @Override
    int getNo() {
        System.out.println("TypeX.getNo()");
        return no;
    }
}
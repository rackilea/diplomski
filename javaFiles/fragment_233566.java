class RTExcept {
public static void throwit(){
    System.out.print("throwit ");
    throw new RuntimeException();
}
public static void main(String[] args) {
    try{
        System.out.print("hello ");
        throwit();
    } catch (Exception e){
        System.out.print(" caught " + e.getClass());
    } finally{
        System.out.print(" finally ");
    }
    System.out.print(" after ");
}
}
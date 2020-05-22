public class Test {
    public static void main(String args[]) {
        String str="Hello World!";
        String newStr="";
        int startFrom=2,endBefore=5;//test startFrom and endBefore indices
        for(int i=startFrom;i<endBefore;i++)
            newStr+=str.valueOf(str.charAt(i));
        System.out.println(newStr);
    }
}
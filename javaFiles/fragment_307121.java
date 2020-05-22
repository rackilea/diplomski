public class ClassTwo {    
    public static void main(String [] args){
        InputStream replacedIn = new ByteArrayInputStream("1\n2\n3\n4\n".getBytes());
        System.setIn(replacedIn);
        ClassOne.main(null);
    }
}
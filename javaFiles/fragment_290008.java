public class Example {

    private HashMap<String, String> hashmap = new HashMap<String, String>();

    public HashMap<String, String> getHashmap() {
        return hashmap;
    }

    public void setHashmap(HashMap<String, String> hashmap) {
        this.hashmap = hashmap;
    }
}

public class AnotherClass {

    public static void main(String args[]) {
        Example ex = new Example();
        HashMap<String, String> hm = ex.getHashmap();
    } 

}
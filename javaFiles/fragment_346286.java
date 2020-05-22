public class Main {
    public static class FMList {
        public long size = 0;
        public int dirs = 0;
        public int files = 0;
        public String path = "";
    }

    public static void main(String[] args) {
        System.out.println(new JSONObject(new FMList(), new String[] { "dirs", "files" }).toString());
    }

}
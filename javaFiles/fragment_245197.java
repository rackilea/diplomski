import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        List<Tag> tags = new ArrayList<Tag>(25);
        tags.add(new Tag("begin"));
        tags.add(new Tag("front"));
        tags.add(new Tag("start"));
        tags.add(new Tag("finish"));
        tags.add(new Tag("tail"));
        tags.add(new Tag("end"));

        boolean isSuccessful = tags.stream().filter(tag -> tag.getKey().equals("start") || tag.getKey().equals("end")).count() >= 2;
        System.out.println(isSuccessful);
    }

    public class Tag {
        private String key;

        public Tag(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }


    }
}
public class EnumTest {
    public enum Tags {
        RESOURCE_ID("ResourceId"), 
        REOURCE_NAME("ResourceName"), 
        RESOURCE_PRICE("ResourcePrice");

        private final String tagName;
        Tags(String tagName) {
            this.tagName = tagName;
        }

        public String getTagName() {
            return tagName;
        }
    }

    public static void main(String[] args) {
        for(Tags tag : Tags.values()) {
            System.out.println("const:" + tag.name() 
                    + " tagName:" + tag.getTagName());
        }
        // API user might do e.g.:
        // document.getValueForTag(Tags.REOURCE_NAME);
    }
}
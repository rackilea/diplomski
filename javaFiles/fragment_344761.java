public class Blog {

private Boolean isDisabled = false;
private Boolean canCreateTags = true;
private Boolean canCreateCategories = true;
private Boolean hasRss = false;

    @Override
        public String toString() {
            return "Blog{" +
                    "isDisabled='" + isDisabled + '\'' +
                    ", canCreateTags='" + canCreateTags + '\'' +
                    ", canCreateCategories=" + canCreateCategories +
                    '}';
        }
    }
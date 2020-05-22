@JsonIgnoreProperties(ignoreUnknown = true)
static class Post {
    public int id;
    public String type;
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Mapper {
    public ArrayList<Post> posts;
}
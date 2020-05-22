public class Comment {
    private Integer      id;
    private Integer      parentId; // Parent ID was missing
    private Issue        issue;
    private User         author;
    private String       body;
    private Date         created;
    private Date         updated;

    private Comment      parent; // Reference to parent though parentId
    private Set<Comment> childs = new HashSet<Comment>(0);


    protected Comment () {

    }

   // All setters and getters
}
interface CommentItem {
    public String getComment();
}


class ModeratorComment implements CommentItem {
    public String getComment() {
        return "Comment from moderator";
    }
    // other moderator-specific code...
}



class StudentComment implements CommentItem {
    public String getComment() {
        return "Comment from student";
    }
    // other student-specific code...
}


class CommentContainer {

    private List<CommentItem> commentList;

    public List<CommentItem> getCommentList() {
        return commentList;
    }

    public void addComment(CommentItem someComment) {
        commentList.add(someComment);
    }
}


class TestIt() {

    public static void main(String[] args) {

        StudentComment sc = new StudentComment();
        ModeratorComment mc = new ModeratorComment();

        CommentContainer comments = CommentContainerFactory.createCommentContainer();
        comments.add(sc);
        comments.add(mc);

        for (CommentItem ci : comments.getCommentList()) {
            System.out.println(ci.getComment());
        }

    }

}
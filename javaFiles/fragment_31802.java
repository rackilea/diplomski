static class Comment { }

static class User { }

interface SortBy<T, M> { }

static class CommentSortBy<M> implements SortBy<Comment, M> {

    static final CommentSortBy<Date> CREATION = new CommentSortBy<Date>();
    static final CommentSortBy<Integer> VOTES = new CommentSortBy<Integer>();
}

static class UserSortBy<M> implements SortBy<User, M> {

    static final UserSortBy<String> NAME = new UserSortBy<String>();
}

static class Query<T> {

    public <M> void setSort(SortBy<T, M> sortBy, M min) {
        //Set relevant values
    }
}

public static void main(String[] args) {

    new Query<Comment>().setSort(CommentSortBy.CREATION, new Date());
    new Query<Comment>().setSort(UserSortBy.NAME, "Joe"); //compiler error
}
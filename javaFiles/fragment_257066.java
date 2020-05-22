Observable<Comment> getInnerComments(Comment comment) {
    if (comment.childIds.length > 0)
        return Observable.merge(
                Observable.just(comment),
                Observable.from(comment.childIds)
                        .flatMap(id -> getComments(id))
                        .flatMap(this::getInnerComments));
    return Observable.just(comment);
}

public static void main(String[] args) {
    getComments(1)
          .flatMap(this::getInnerComments)
          .subscribe(c -> System.out.println(comment.toString()));
}
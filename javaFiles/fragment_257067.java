getNews(99)
        .flatMap(news -> Observable.from(news.commentIds))
        .flatMap(commentId -> getComments(commentId))
        .flatMap(comment -> getInnerComments(comment))
        .toList()
        .subscribe(commentList -> { });
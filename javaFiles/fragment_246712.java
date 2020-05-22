public String userNext() {
    userReset(false);
    getUserPagingInfo().nextPage();
    movieController.setRunsOneMore();
    return "user_movie_detail";
}

public String userPrev() {
    userReset(false);
    getUserPagingInfo().previousPage();
    movieController.setRunsOneLess();
    return "user_movie_detail";
}
class UserActionFactory {
    public UserAction make(int actionId) {
        switch (actionId) {
            0: return new ListMovies();
            1: return new ExitProgram();
            default: return new Noop();
        }
    }
}
interface UserAction { 
    public void execute();
}

class ListMovies implements UserAction { 
    public void execute() {
        // List the movies
    }
}

class ExitProgram implements UserAction { 
    public void execute() {
        // Kill kenny
    }
}

class Noop implements UserAction { 
    public void execute() {
        // Do nothing
    }
}
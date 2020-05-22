interface Subjectable {
    String getSubject();
}

class Achievement implements Subjectable {
    ...
    @Override
    public String getSubject() {
        return "Achievement unlocked: " + getTitle();
    }
}

class User implements Subjectable {
    ...
    @Override
    public String getSubject() {
        return "Forgot password: " + getEmail();
    }
}
static class Parent {

    public void sharedFunction() {
    }

    final Runnable nitpick;

    public void nitPick() {
        nitpick.run();
    }

    public Parent(Runnable nitpick) {
        this.nitpick = nitpick;
    }

}

public static void main(String[] args) {

    Parent alpha = new Parent(() -> {/* alpha specific code goes here*/});

}
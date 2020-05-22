static interface Parent {

    default public void sharedFunction() {
    }

    abstract void nitpick();

}

public static void main(String[] args) {

    Parent alpha = () -> {/* alpha specific code goes here*/
    };

}
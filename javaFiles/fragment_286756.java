static abstract class Parent {

    public void sharedFunction() {

    }

    abstract void nitpick();

}

public static void main(String [] args) {

    Parent alpha = new Parent() {
        @Override
        void nitpick() {
            /*
            alpha specific code here
            */
        }
    };

}
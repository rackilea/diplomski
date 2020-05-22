public abstract class Animal {

    public void abstract updateImage();
}

public class Dog extends Animal {

    public void updateImage() {
        // Do dog-specific stuff here
    }
}

public class Cat extends Animal {

    public void updateImage() {
        // Do cat-specific stuff here
    }
}
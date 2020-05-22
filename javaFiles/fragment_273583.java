public class Builder {
    private String name;
    private Helmet helmet;

    public Builder(String name) {
        this.name = name;
    }


    /* Helmet methods - helmet is a data member */

    public void wearHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public void adjustHelmet() {
        helmet.adjust();
    }

    public void sayHello() {
        helmet.raise();
    }


    /* Can he fix it? Yes he can! But he doesn't keep it afterwards */

    public void fix(It it) {
        straighten(it);
        paint(it);
        shine(it);
    }

    private void straighen(It it) {
        // implementation
    }

    private void paint(It it) {
        // implementation
    }

    private void shine(It it) {
        // implementation
    }
}
public interface Actionable {
    void doItemAction();
}

public class Item implements Actionable {
    @Override
    public void doItemAction() {
        // insert or print
    }
}

public static void main(Actionable... args) {
    for (Actionable item : args) {
        item.doItemAction();
    }
}
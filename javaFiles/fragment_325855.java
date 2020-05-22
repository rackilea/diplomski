public class Main {
public static void main(String[] args) {
    Tool firestone = new Tool(new Fire(), new Stone());
}

private static interface Component {
    int getDmg();
    int getDef();
}

private static class Fire implements Component {
    @Override
    public int getDmg() {
        return 1;
    }

    @Override
    public int getDef() {
        return 0;
    }
}

private static class Stone implements Component {
    @Override
    public int getDmg() {
        return 0;
    }

    @Override
    public int getDef() {
        return 1;
    }
}

private static class Tool implements Component {
    List<Component> components;
    int dmg;
    int def;

    public Tool(Component... component) {
        components = new ArrayList<>();
        components.addAll(Arrays.asList(component));
        dmg = 0;
        def = 0;
        for (Component c : components) {
            dmg += c.getDmg();
            def += c.getDef();
        }
    }

    @Override
    public int getDmg() {
        return dmg;
    }

    @Override
    public int getDef() {
        return def;
    }
}}
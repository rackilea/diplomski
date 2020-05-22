public class Telescope {
    final String name;
    final int levels;
    final boolean isAdjustable;

    public Telescope(String name) {
        this(name, 5);
    }
    public Telescope(String name, int levels) {
        this(name, levels, false);
    }
    public Telescope(String name, int levels, boolean isAdjustable) {       
        this.name = name;
        this.levels = levels;
        this.isAdjustable = isAdjustable;
    }
}
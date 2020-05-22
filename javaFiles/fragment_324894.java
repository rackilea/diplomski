public class Fact {
    private String name;
    private FactValues values;

    public class FactValues {
        private int state;
        private boolean canBeModified;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public boolean isCanBeModified() {
            return canBeModified;
        }

        public void setCanBeModified(boolean canBeModified) {
            this.canBeModified = canBeModified;
        }
    }

    public Fact(String name, FactValues values) {
        super();
        this.name = name;
        this.values = values;
    }

    public Fact(String name, int state, boolean canBeModified) {
        super();
        this.name = name;

        this.values = new FactValues();
        values.setState(state);
        values.setCanBeModified(canBeModified);
    }

    public FactValues getValues() {
        return values;
    }


    public void setValues(FactValues values) {
        this.values = values;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return values.getState();
    }

    public void setState(int state) {
        values.setState(state);
    }

    public boolean isCanBeModified() {
        return values.isCanBeModified();
    }

    public void setCanBeModified(boolean canBeModified) {
        values.setCanBeModified(canBeModified);
    }

    public static void main(String[] args) {

        Fact b = new Fact("test", 1,true);
        Fact a = new Fact("another test",b.getValues());

        a.setState(5);
        System.out.println(a.getState());
        System.out.println(b.getState());           
    }
}
abstract class AbstractSuper {
    public AbstractSuper() {
        if (getFldName().equals("abc")) {
            //....
        }
    }

    abstract public void setFldName();
    abstract public String getFldName();
}

class Sub extends AbstractSuper {
    @Override
    public void setFldName() {
        ///....
    }

    @Override
    public String getFldName() {
        return "def";
    }
}
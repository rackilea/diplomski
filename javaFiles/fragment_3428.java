public class SecondPower implements Power {
    boolean anotherParam;

    boolean isAnotherParam() {
        return anotherParam;
    }

    void setAnotherParam(boolean anotherParam) {
        this.anotherParam = anotherParam;
    }

    @Override
    public String toString() {
        return "anotherParam:" + String.valueOf(anotherParam);
    }
}
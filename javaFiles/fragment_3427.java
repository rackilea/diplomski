public class FirstPower implements Power {
    String firstTypeParam;

    String getFirstTypeParam() {
        return firstTypeParam;
    }

    void setFirstTypeParam(String firstTypeParam) {
        this.firstTypeParam = firstTypeParam;
    }

    @Override
    public String toString() {
        return "firstTypeParam:" + firstTypeParam;
    }
}
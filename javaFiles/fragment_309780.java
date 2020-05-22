public class MyDataBuilder(){
    private parameter1 = null;
    private parameter2 = null;

    public MyDataBuilder withParameter1(parameter1) {
        this.parameter1 = parameter1;
        return this;
    }

    public MyDataBuilder withParameter2(parameter2) {
        this.parameter2 = parameter2;
        return this;
    }

    public Data createSubClass(){
        Data subClass;

        if (parameter2 != null){
            subClass = new DataFromSpecificSources(parameter1, parameter2);
        } else {
            subClass = new AnotherSubClass(parameter1);
        }
        subClass.loadData();
        return subClass;
    }

}
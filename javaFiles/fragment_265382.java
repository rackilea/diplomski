public interface EnumInterface {

    public String getTitle();

    public void processEvent(SwitchLogicClass e);
}


public enum Enum1 implements EnumInterface{

    A("Apple"){
        public void processEvent(SwitchLogicClass e){
            //Any A specific Logic
            e.doSomethingA();
        }
    },
    B("Ball"){
        public void processEvent(SwitchLogicClass e){
            //Any B specific Logic
            e.doSomethingB();
        }
    };

    private String title;
    Enum1(String title){
        this.title = title;
    }


    @Override
    public String getTitle(){
        return title;
    }
}
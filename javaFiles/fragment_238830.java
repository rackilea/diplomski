public class A extends Base{

    public A(){
        //Do something...
    }

    @Override
    public String showVal(MyEnum value){
        switch(value){
            case MyEnum.X:
                return "a=10,b=11";
            case MyEnum.Y:
                return "a=12,b=13";
            case MyEnum.Z:
                return "a=14,b=15";
        }

    }
}
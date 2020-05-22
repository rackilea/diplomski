public class Base{

    public Base(){
        //Do something...
    }

    public String showVal(MyEnum value){
        switch(value){
            case MyEnum.X:
                return "a=0,b=2";
            case MyEnum.Y:
                return "a=1,b=3";
            case MyEnum.Z:
                return "a=4,b=5";
        }

    }
}
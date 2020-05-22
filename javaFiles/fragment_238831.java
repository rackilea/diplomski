public class B extends Base{

    public B(){
        //Do something...
    }

    @Override
    public String showVal(MyEnum value){
        switch(value){
            case MyEnum.X:
                return "a=20,b=21";
            case MyEnum.Y:
                return "a=22,b=23";
            case MyEnum.Z:
                return "a=24,b=25";
        }

    }
}
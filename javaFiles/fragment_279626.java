public class Nice {

    private Nice(){}

    public static badNamedEnum one(){
        return badNamedEnum.badNamedOne;
    }

    public static badNamedEnum two(){
        return badNamedEnum.badNamedTwo;
    }
}
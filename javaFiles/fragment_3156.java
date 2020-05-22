public class VehicleRestModel {

    private String concatValue = "";
    private int splitIndex;   

    @JsonSetter("var1")
    public setVar1(String var1){ concatValue = var1 + concatValue.substring(splitIndex,concatValue.length()); ; splitIndex = var1.length(); }
    @JsonSetter("var2")
    public setVar2(String var2){ concatValue = concatValue.substring(0,splitIndex) + var2; }

}
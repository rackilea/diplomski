/**
 * input: "9BB2A2B8DF8747B0982F2F1702E1D18B"
 * output: "B8A2B29B-87DF-B047-982F-2F1702E1D18B";
 */
public String hexToStr(String guid) {       
    return guid.replaceAll("(.{8})(.{4})(.{4})(.{4})(.{12})", "$1-$2-$3-$4-$5").replaceAll("(.{2})(.{2})(.{2})(.{2}).(.{2})(.{2}).(.{2})(.{2})(.{18})", "$4$3$2$1-$6$5-$8$7$9");
}
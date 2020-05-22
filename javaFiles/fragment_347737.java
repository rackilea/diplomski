String input1 = "EN(T)ICE (NIECE anag)";
String input2 = "AP(PEAR + ANC)E (CAN anag)";
String input3 = "CHIC (\"SHEIK\" hom)";

System.out.println(extract(input1));
System.out.println(extract(input2));
System.out.println(extract(input3));

public static String extract(String s){
    return s.split(" \\(.*")[0]
            .replace("(", "")
            .replace(")", "")
            .replace(" + ", "");
}
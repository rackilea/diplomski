String yourString = "<210>   DW_AT_name        : (indirect string, offset: 0x55): double";
String result;
if (yourString.contains("DW_AT_name")) {
    int lastIndex = yourString.lastIndexOf(":");
    result = yourString.substring(lastIndex + 1).trim();
} else {
    result = "ERROR"; // or handle this however you want
}
System.out.println(result);
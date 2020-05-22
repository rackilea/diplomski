//resultStr = [["UIButton","Submit","15","30","80","80"],["UILabel","User name","15","75","80","80"],["UITextField","Jonathan","15","75","80","80"]]ˇ˛END
if ( resultStr.length()>7 && resultStr!=null ) {

    String[] resStrings = resultStr.substring(2, resultStr.length()-7).split("\\],\\[");    
    for (String resString: resStrings) {
        System.out.println("Applet resStr: " + resStr);
    }
}
public String changeXY(String str) {
    if (str.isEmpty()) return "";
    else if (str.substring(0,1).equals("x") && str.length()<2) return "y";
    else if (!str.substring(0,1).equals("x") && str.length()<2) return str;
    else if (str.substring(0,1).equals("x") && str.length()>1) return "y" + changeXY(str.substring(1));
    else if (!str.substring(0,1).equals("x")) return str.substring(0,1) + changeXY(str.substring(1));

    return changeXY(str);
}
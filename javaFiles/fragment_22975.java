String message = "";
int num1 = Integer.parseInt(Val1.trim());
int num2 = Integer.parseInt(Val2.trim());
if (Compute.equals("<")) {
    if (num1 < num2)
        message = "True";
    else
        message = "" + num1 + ">=" + num2;
} else if (Compute.equals(">")) {
    if (num1 > num2)
        message = "True";
    else
        message = "" + num1 + "<=" + num2;
} else if (Compute.equals("<=")) {
    if (num1 <= num2)
        message = "True";
    else
        message = "" + num1 + ">" + num2;
} else if (Compute.equals(">=")) {
    if (num1 >= num2)
        message = "True";
    else
        message = "" + num1 + "<" + num2;
}
System.out.println(message);
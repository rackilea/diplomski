protected static string receiveInput(String arg) {
    String result;
    String command = arg;
    boolean b = true;

    while (b) {
        switch(command) {

            case "first":
                result = "first";
                break;

            case "second":
                result = "second";
                break;

            case "third":
                result = "third";
                break;

            default:
                result = "\n ****Invalid*** \n"; 
        }
    }
    return result;
}
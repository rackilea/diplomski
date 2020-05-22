private void test(){

    String sms = "You have sent UGX10,000 to 08970000.\n" +
            "Reason:j.\n" +
            "Your balance is UGX120,000.\n" +
            "Thank you for using KKL MobileMoney.";

    /*String rec = "You have received UGX100,000 from 09006700. Reason:J.\n" +
            "Your balance is UGX170,000.";
    String air = "Airtime payment made for UGX5,000 to KKL(0909xxxx).\n" +
            "Your Balance is UGX10,000.\n" +
            "Thank you for using KKL MobileMoney.";
    */
    Map<String, String> data = parseSms(sms);
    saveToDB(data);

}


private void saveToDB(Map<String, String> data){
    db.addrecord(data.get("amount"), data.get("type"), data.get("reason"), data.get("number"), data.get("balance"));
    db.close();
}

private Map<String, String> parseSms(String s){
    Map<String, String> ret = new HashMap<String, String>();
    s = s.replace("\n", "");
    StringTokenizer t = new StringTokenizer(s, ".");
    while (t.hasMoreTokens()){
        String b = t.nextToken().trim();
        if (b.startsWith("You have sent") ||  (b.startsWith("Airtime") || (b.startsWith("You have received")))){
            String type = getType(b);
            String parsed = parseAmount(b);
            String number = parseNumber(b);
            ret.put("amount", parsed);
            ret.put("number", number);
            ret.put("type", type);
        }else if(b.startsWith("Your")){//balance
            String parsed = parseAmount(b);
            ret.put("balance", parsed);
        }else if (b.startsWith("Reason")){
            ret.put("reason", b.toString());
        }
    }

    return ret;
}

private String getType(String s){
    if (s.startsWith("You have sent"))//Use your constants
        return "Payment";
    else if (s.startsWith("Airtime"))
        return "Air time";
    else if (s.startsWith("You have received"))
        return "Deposit";

    return "Unknown";
}


private String parseNumber(String s){
    String numberFragment = s.substring(s.lastIndexOf(' '), s.length());//extract number
    return numberFragment;
}

private String parseAmount(String s){
    char[] arr = s.toCharArray();
    StringBuffer sb = new StringBuffer();
    boolean parsingNumber = false;
    for (char c: arr){
        if (Character.isDigit(c))
            parsingNumber = true;
        if (Character.isLetter(c)  && c != ',' )
            parsingNumber = false;
        if (parsingNumber && c == ' ')//we have reached end of digit series
            break; //done
        if (parsingNumber)
            sb.append(c);
    }

    return sb.toString();
}
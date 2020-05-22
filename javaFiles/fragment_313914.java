public static void main(String[] args) throws Exception {
    String data = "1,2,{3,{4},5},{5,6},-7,{7,8},{8,{9},10},11";
    List<String> list = new ArrayList();
    for (int i = 0; i < data.length(); i++) {
        if ((Character.isDigit(data.charAt(i))) ||
            // Include negative numbers
             (data.charAt(i) == '-') && (i + 1 < data.length() && Character.isDigit(data.charAt(i + 1)))) {
            // Get the number before the comma, unless it's the last number
            int commaIndex = data.indexOf(",", i);
            String number = commaIndex > -1
                    ? data.substring(i, commaIndex)
                    : data.substring(i);
            list.add(number);
            i += number.length();
        } else if (data.charAt(i) == '{') {
            // Get the group of numbers until you reach the final 
            // closing curly brace
            StringBuilder sb = new StringBuilder();
            int openCount = 0;
            int closeCount = 0;
            do {
                if (data.charAt(i) == '{') {
                    openCount++;
                } else if (data.charAt(i) == '}') {
                    closeCount++;
                }
                sb.append(data.charAt(i));
                i++;
            } while (closeCount < openCount);
            list.add(sb.toString());
        }
    }

    for (int i = 0; i < list.size(); i++) {
        System.out.printf("Arr[%d]: %s\r\n", i, list.get(i));
    }
}
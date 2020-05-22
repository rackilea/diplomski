String[] b = line.split(" ");
    String phoneNumber = null;
    for (String x : b) {
        boolean z = false;
        if (x.length() == 10) {

            char[] c = x.toCharArray();
            for (char g : c) {
                if (Character.isDigit(g)) {
                    z = true;
                } else {
                    z = false;
                    break;
                }
            }

        } else {
            z = false;
        }
        if (z) {
            phoneNumber = x;
        }
}
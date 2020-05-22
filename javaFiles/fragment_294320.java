public static String cipher(String input2, Integer number) {
        StringBuilder builder = new StringBuilder(input2.length());
        int k = number;
        int lowerBoundlc = 97;
        int upperBoundlc = 122;
        int lowerBounduc = 65;
        int upperBounduc = 90;
        for (int i = 0; i < input2.length(); i++) {
            char c = input2.charAt(i);
            int j = (int) c;
            if ((lowerBoundlc <= j && j <= upperBoundlc) || (j == 45)) {
                if (j == 45) {
                    builder.append((char) j);
                } else {
                    int addk = j + k;
                    if (addk > upperBoundlc) {
                        int lowercase = addk % upperBoundlc;
                        int resultlc = lowerBoundlc + lowercase -1;
                        builder.append((char) resultlc);
                    } else {
                        builder.append((char) addk);
                    }
                }

            } else {
                if ((lowerBounduc <= j && j <= upperBounduc) || (j == 45)) {
                    int addnewk = j + k;
                    if (addnewk > upperBounduc) {
                        int uppercase = addnewk % upperBounduc;
                        int resultuc = lowerBounduc + uppercase -1;
                        builder.append((char) resultuc);
                    } else {
                        builder.append((char) addnewk);
                    }
                }
            }
        }
        return builder.toString();    
    }
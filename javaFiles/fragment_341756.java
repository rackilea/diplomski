String str = "IF(AND(ROUND($GX18-SUM(0)/$M$12;2)<=0$AK$7=1);0;OR(1;A2)+O2)";
        char[] ch = str.toCharArray();
        int count = 0;
        String temp = "";
        for (int i = 0; i < ch.length; i++) {
            temp = temp + ch[i];
            if ("AND(".equals(temp) || "OR(".equals(temp)) {
                count++;
            }
            if ("(".equals(temp) && count > 0) {
                count++;
            }
            if (")".equals(temp) && count > 0) {
                count--;
            }
            if (";".equals(temp) && count == 0) {
                ch[i] = '#';
            }
            if ((!"AND(".startsWith(temp) && !"OR(".startsWith(temp)) || temp.length() > 4) {
                temp = "";
            }
        }
        System.out.println("Expected Data >> " + String.valueOf(ch));
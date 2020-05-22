// String[] litteralPhone = request.getParameter("phone").split(" ") ;
    final String litteralPhone = "0033 (119999999990";
    final int i = litteralPhone.indexOf(")");
    if (i > 0) {
        if (litteralPhone.substring(i).length() > 8) {
            System.out.println(litteralPhone.replaceAll(
                "^[0]{1,}|[ ]{0,}\\(|\\)[ ]{0,}", ""));
        } else {
            System.out.println("error with ()");
        }
    } else {
        // suppress trailing ( 
        final String[] tabNum = litteralPhone.replaceAll("\\(|\\)", "").split(" ");

        switch (tabNum.length) {
            case 1 : // 003311236549879879
               tabNum[0] = tabNum[0].replaceAll("^[0]{1,}", "");
               if (tabNum[0].length() < 10) { // tune this lenght
                      System.out.println("error 1");
                }
                break;
            case 2 : // 033 01234567890
                tabNum[0] = tabNum[0].replaceAll("^[0]{1,}", "");
                tabNum[1] = tabNum[1].replaceAll("^[0]", "");
                if (tabNum[1].length() < 8) {
                    System.out.println("error 2");
                }
                break;
            case 3 : // +33 1 012346577979
                tabNum[0] = tabNum[0].replaceAll("^[0]{1,}", "");
                tabNum[2] = tabNum[2].replaceAll("^[0]", "");
                if (tabNum[2].length() < 8) {
                    System.out.println("error 3");
                }
                // add all cases here
            default :
                System.out.println("not a good phone number");
                break;
        }
        final StringBuilder sb = new StringBuilder();
        for (final String string : tabNum) {
            sb.append(string);
        }
        System.out.println(sb.toString());
    }
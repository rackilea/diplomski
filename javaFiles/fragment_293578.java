for (WebElement ele : monthlist) {
            System.out.println(ele.getText());
            String[] fbmonth = ele.getText().trim().split("\n");
            for(j=0;j<fbmonth.length;j++) {
                System.out.println("fbmonth" +j +"="+ fbmonth[j] );
                if (fbmonth[j].equals(month)) {
                    System.out.println(fbmonth[j] + " project is displaying");

                }
            }



        }
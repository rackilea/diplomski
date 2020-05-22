System.out.println(message);
            String finalmessage = "";
            String sss = "";
            char ch = 0;

        for(int i = 0 ; i < message.length();i++){

             ch = message.charAt(i);
            int j = (int) ch;
        //  System.out.println("iiii::"+j);

            sss = "&#"+j+";";
            finalmessage = finalmessage+sss;
        }
        System.out.println("ddd"+finalmessage);

        message=finalmessage;
        System.out.println("unicoded message=="+message);
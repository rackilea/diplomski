String scz = "3282E81WHT-22/24";

            String Third[] = scz.split("-");
            String rev = new StringBuilder(Third[0]).reverse().toString();
            String Second=rev.substring(0,3);
            String First=rev.substring(3,rev.length());

            // here Reverse your String Back to Original
            First=new StringBuilder(First).reverse().toString();
            Second=new StringBuilder(Second).reverse().toString();

            System.out.println(First + "  " + Second + "  " + Third[1]);
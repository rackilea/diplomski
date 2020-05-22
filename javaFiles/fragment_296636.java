Pattern p = Pattern.compile("(([+-])(\\d+)(WD|[DWM]))");
        Matcher m = p.matcher("+1D-2WD+3M");
        while(m.find()){
            System.out.println(m.group(1));
            // Splitted argument
            System.out.println("Operator : " +  m.group(2));
            System.out.println("Number : " +  m.group(3));
            System.out.println("Period : " +  m.group(4));

        }
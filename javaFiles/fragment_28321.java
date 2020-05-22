String example="[11/2/19 9:48:25] Timestamp=1549878505 ID=4 Value=2475";          
        Pattern pattern=Pattern.compile(".*Timestamp=(\\d+).*ID=(\\d+).*Value=(\\d+)");
        Matcher matcher = pattern.matcher(example);
        while(matcher.find()) {
            System.out.println("Timestamp is:" + matcher.group(1));
            System.out.println("Id is:" + matcher.group(2));
            System.out.println("Value is:" + matcher.group(3));
        }
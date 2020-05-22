double totalToConvert = 3.02;
        int totalAsInteger = (int) totalToConvert;
        System.out.println(totalAsInteger);
        int decimalPart = (int)((double)(totalToConvert-totalAsInteger)*100);
        int total = totalAsInteger*10 +decimalPart;
        System.out.println(total

);
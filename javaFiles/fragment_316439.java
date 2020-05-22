StringBuffer sb = new StringBuffer();
DateFormat dateInstance = new SimpleDateFormat("yy-MM-dd");
System.out.println(dateInstance.format(today));
dateInstance.format(today, sb, yearPosition);
sb.replace(yearPosition.getBeginIndex(), yearPosition.getEndIndex(), 
        fourDigitsYearOnlyFormat.format(today));
System.out.println(sb.toString());
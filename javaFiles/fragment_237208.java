Date[] dates=//....;
List<String> listToSort=new ArrayList<String>(dates.length);
SimpleDateFormat format=new SimpleDateFormat ("yyyyMMddHHmmssSSS");
for(Date date: dates) {
   String sDate=format.format(date);
   listToSort.add(sDate);
}
Collections.sort(listToSort);
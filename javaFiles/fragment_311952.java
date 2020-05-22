String[] columnNames = new String[2];

columnNames[0] = "ID";
columnNames[1] = "Name";

String[] person1 = new String[2];

person1[0] = "1";
person1[1] = "George";

ArrayList<String[]> csvExport = new ArrayList<String[]>();
csvExport.add(columnNames);
csvExport.add(person1);
CSVWriter export=new CSVWriter(new FileWriter("/sdcard/"+stock+".csv"));
export.writeAll(csvExport, true);
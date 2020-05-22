...
String cellTimeStringTime = "00:" + minutes + ":" + seconds;
double timeValue = DateUtil.convertTime(cellTimeStringTime);
double millisecValue = Double.parseDouble(""+milliseconds);
millisecValue = millisecValue / 24 / 60 / 60 / 1000;
timeValue += millisecValue;
cell.setCellValue(timeValue);
...
StringBuffer csvContent = new StringBuffer(); // a content of buffer
String pageListProp = tools.getParamValue("PageListProperty");
ClipboardProperty resultsProp = myStepPage.getProperty(pageListProp);

// fill the properties names list
java.util.List<String> propertiesNames = new java.util.LinkedList<String>(); // names of properties which values display in csv
String csvProps = tools.getParamValue("CSVProperties");
propertiesNames = java.util.Arrays.asList(csvProps.split(","));

// get user's colums names
java.util.List<String> columnsNames = new java.util.LinkedList<String>();
String CSVDisplayProps = tools.getParamValue("ColumnsNames");
if (!CSVDisplayProps.isEmpty()) {
  columnsNames = java.util.Arrays.asList(CSVDisplayProps.split(","));
} else {
  columnsNames.addAll(propertiesNames);
}

// add columns to csv file
Iterator columnsIter = columnsNames.iterator();
while (columnsIter.hasNext()) {
  csvContent.append(columnsIter.next().toString());
  if (columnsIter.hasNext()){
    csvContent.append(listSeperator); // listSeperator - local variable
  }
}
csvContent.append("\r");

for (int i = 1; i <= resultsProp.size(); i++) { 
  ClipboardPage propPage = resultsProp.getPageValue(i); 
  Iterator iterator = propertiesNames.iterator(); 
  int propTypeIndex = 0;
  while (iterator.hasNext()) {
    ClipboardProperty clipProp = propPage.getIfPresent((iterator.next()).toString());

    String propValue = "";
    if(clipProp != null && !clipProp.isEmpty()) {
      char propType = clipProp.getType();
      propValue = clipProp.getStringValue();

      if (propType == ImmutablePropertyInfo.TYPE_DATE) {
        DateTimeUtils dtu = ThreadContainer.get().getDateTimeUtils();
        long mills = dtu.parseDateString(propValue);
        java.util.Date date = new Date(mills);
        String sdate = dtu.formatDateTimeStamp(date);
        propValue = dtu.formatDateTime(sdate, "dd.MM.yyyy", "", "");
      } 
      else if (propType == ImmutablePropertyInfo.TYPE_DATETIME) {
        DateTimeUtils dtu = ThreadContainer.get().getDateTimeUtils();
        propValue = dtu.formatDateTime(propValue, "dd.MM.yyyy HH:mm", "", "");
      } 
      else if ((propType == ImmutablePropertyInfo.TYPE_DECIMAL)) {
        propValue = PRNumberFormat.format(localeCode,PRNumberFormat.DEFAULT_DECIMAL, false, null,  new BigDecimal(propValue));
      } 
      else if (propType == ImmutablePropertyInfo.TYPE_DOUBLE) {
        propValue = PRNumberFormat.format(localeCode,PRNumberFormat.DEFAULT_DECIMAL, false, null,  Double.parseDouble(propValue));
      } 
      else if (propType == ImmutablePropertyInfo.TYPE_TEXT) {
        propValue = clipProp.getLocalizedText();
      } 
      else if (propType == ImmutablePropertyInfo.TYPE_INTEGER) {
        Integer intPropValue = Integer.parseInt(propValue);
        if (intPropValue < 0) {
          propValue = new String();
        }

      }
    }
    if(propValue.contains(listSeperator)){
      csvContent.append("\""+propValue+"\"");
    } else {
      csvContent.append(propValue);
    }
    if(iterator.hasNext()){
      csvContent.append(listSeperator);
    }
    propTypeIndex++;
  }
  csvContent.append("\r");
}

CSVString = csvContent.toString();
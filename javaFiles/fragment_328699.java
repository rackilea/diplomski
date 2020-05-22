String[] selectedTableRecords = getJTableSelectedRowsData(jTable1); 
StringBuilder sb = new StringBuilder();
for (String str : selectedTableRecords) {
    sb.append(str).append(System.lineSeparator());
} 

jTextArea1.setText(sb.toString());
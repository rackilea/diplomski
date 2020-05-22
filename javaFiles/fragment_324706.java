int count = 0;
String[][] arr = new String[262978][3];
Pattern p = Pattern.compile("'(.*?)'(?![a-zA-Z])"); 
//while the file is still reading
while ((line_0 = br_0.readLine()) != null) {           
     Matcher m = p.matcher(line_0);
     int j = 0;
     while (m.find()) {
         arr[count][j++] = m.group(1);
     }
     count++;
}

br_0.close();
List<List<String>> arr = new ArrayList<>();
Pattern p = Pattern.compile("'(.*?)'(?![a-zA-Z])"); 
//while the file is still reading
while ((line_0 = br_0.readLine()) != null) {
     List<String> three = new ArrayList<>();         
     Matcher m = p.matcher(line_0);
     int j = 0;
     while (m.find()) {
         three.add( m.group(1) );
     }
     arr.add( three );
}

br_0.close();
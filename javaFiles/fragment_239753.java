String str = "1-Mar-2019 to 31-Mar-2019";

String startdt = null, enddt = null;

Pattern p = Pattern.compile("(\\d{1,2}-[a-zA-Z]{3}-\\d{4})");  
Matcher m = p.matcher(str);
if(m.find()) {
    startdt = m.group(1); 
    if(m.find()) {
       enddt = m.group(1);
    }
}   
System.out.println("startdt: "+startdt+" enddt: "+enddt);
Map<String, Integer> conversions = new HashMap<String, Integer>();
conversions.put("KB", 1000);
conversions.put("MB", 1000000);

//Get numbers from String.
double doubleSize = Double.parseDouble(size.replaceAll("[A-Z]+$", "")); 
//Get units from String.
String units = size.replaceAll("[0-9.]", "");  

double bytes = doubleSize * conversions.get(units);

if (bytes <= 250000) {
    //Do something.
}
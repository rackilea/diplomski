int convert_from_Roman(String value) {  
    value.trim(); // result of trim is ignored
    int convertedValue = 0;
    for (int i = 0; i <= value.length(); i++) { // your exceeding the index by 1
        char romanVal = value.charAt(i);
        for(String romanNumeral : romanArr) {
            if (romanNumeral.equals(romanVal)) { // string - char comparison
                 convertedValue += arabicArr[romanNumeral.indexOf(i)]; // wrong index
            }
            else 
                continue;
        } 
    } 
    return convertedValue;
}
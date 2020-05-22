for (i = 0; i < 3; i++) { 
    int j = 2; 
    a = line.charAt(i);      
    sum += Character.getNumericValue(a) * Math.pow(26, j); 
    j--; 
}
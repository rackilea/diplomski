int j = 2; 

for (i = 0; i < 3; i++) { 
    a = line.charAt(i);      
    sum += Character.getNumericValue(a) * Math.pow(26, j); 
    j--; 
}
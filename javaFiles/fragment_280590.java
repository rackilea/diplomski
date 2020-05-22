if ((genderint == 0 || genderint ==1) && (ageint >=18 && ageint < 26)) {
    group = "Category A"; 
} else if(genderint == 0 && ageint >= 27 && ageint < 60){
    group = "Category B"; 
} else if(genderint == 1 && ageint >= 27 && ageint < 60) {
    group = "Category C"; 
} else if((genderint == 0 || genderint == 1) && ageint >= 60) {
    group = "Category D";
} else if((genderint == 0 || genderint ==1) && ageint <18){
    JOptionPane.showMessageDialog(null,"Sorry, you're too young"); 
}
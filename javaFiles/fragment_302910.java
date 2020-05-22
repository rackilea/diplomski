// knowing that it can never be -1
// so if that value remains, you know that user entered wrong letter
ActivityFactor = -1

// then the conditional begins
if((inGender.equalsIgnoreCase("M") ||(inGender.equalsIgnoreCase ("F"))) && inActivity.equalsIgnoreCase("A"))
...

// after conditional...
if(activityFactor != -1){
    double TDEE = (nBMR * ActivityFactor);
}
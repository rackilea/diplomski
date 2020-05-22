// in getHours() :

double hours = 12.5;

if(hours < 13) { //check to make sure hours is valid/correct
    return hours;
}
else{
    throw new Exception("Hours value of " + hours + " is not valid");
}

// in main class:

try{
    hours = getHours();
}
catch(Exception e){
    e.printStackTrace();
}
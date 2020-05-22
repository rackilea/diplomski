if(pID.substring(0, 3).equalsIgnoreCase(ini) && pID.substring(3).matches("^[0-9]{3}$")){
    return true;
}
else {
    return false
};
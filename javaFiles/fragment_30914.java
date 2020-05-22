@Override
public String toString() {
    String returnString = getForename() + ", " + getSurname() + "(" + getId() +
            "): " + getPositionName() + "at " + salary.getSalary() + " (" + salary.calculateTax() + ") and is ";

    if(eligibleForBonus()){
        returnString += "eligible for bonus.";
    }else{
        returnString += "not eligible for bonus.";
    }

    return returnString;

}
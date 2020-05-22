public class Household {

    List<Class1> peopleList = new ArrayList<>();
    public String householdName;

    public String setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public void addPeopleToHousehold(Class1 people) {
        peopleList.add(people);
    }

    public int getNumberOfPeople() {
        return peopleList.size();
    }

    public String toString() {
        String returnString = "";
        if (householdName != null) {
            returnString = householdName + ": ";
        }

        // Loop the members
        for (int i = 0; i < peopleList.size(); i++) {
            returnString += peopleList.get(i).getMiddleName();
            if ((i + 1) != peopleList.size()) {
                returnString += ", ";
            }
        }

        return returnString;
    }
}
Airline al = null;
int totalPoints;
for (int j = 0; j < members.size(); j++) {
    al = members.get(j);
    if (al.lastName.equals(lastNameField.getText())) {
        totalPoints = al.week1 + al.week2 + al.week3 + al.week4;
    }
}
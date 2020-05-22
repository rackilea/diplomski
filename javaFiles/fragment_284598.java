int totalPoints;
    for (Airline al:members) {
        if (al.lastName.equals(lastNameField.getText())) {
            totalPoints = al.week1 + al.week2 + al.week3 + al.week4;
        }
    }
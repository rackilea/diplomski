// at first you check if the ID is equal to abfrage and add it to list
if (driver.getId() == abfrage.getId()) {
    tobedeletet.add(aktuell);
    temp = driver;
}

// at the end you formed a list tobedeleted witch contains elements with the same ID.

for (Fahrer aktuell : tobedeletet) {
    session.remove(aktuell);
}
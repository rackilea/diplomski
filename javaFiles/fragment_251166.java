int index = 0;
boolean resultFound = false;
for (String car : carData) {
    if (car.indexOf(query) != -1) {
        resultFound = true;
        break;
    }
    index++;
}
if (resultFound) {
    ...
}
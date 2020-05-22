int index = -1;
for (int i = 0; i < Yellow_Li.length(); i++) {
    if (Yellow_Li[i].equals(selectedValue)) {
        index = i;
        break;
    }
}

String value = Yellow_ID[index]; //should do a check for -1 before you try to assign "value"
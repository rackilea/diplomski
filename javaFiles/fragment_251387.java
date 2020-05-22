boolean found = false;
    int a = 0;
    while(!found && a < nameValues.size()) {
        if (customList.getName().equalsIgnoreCase(nameValues.get(a).getName())) {
            found = true;
            break;
        }

        a++;
    }

    if (found) {
        value.setText(String.valueOf(nameValues.get(a).getValue()));
    } else {
        value.setText("");
    }
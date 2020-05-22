List<String> new_valueString = new ArrayList<>();
    List<String> new_fieldsString = new ArrayList<>();
    List<String> oldValueString = new ArrayList<>();
    List<String> oldFieldsString = new ArrayList<>();

  if (new_fieldsString.size() != 0 && new_valueString.size() != 0) {
        for (int l = 0; l < new_fieldsString.size(); l++) {
           for (int m = 0; m < oldFieldsString.size(); m++) {
                if (new_fieldsString.get(l).equalsIgnoreCase(oldFieldsString.get(m))) {
                    if (!new_valueString.get(l).contains(oldValueString.get(m))) {
                        ifUpdated = true;
                    } else {
                        ifUpdated = false;
                    }
                    break;
                }
            }
        }
    }
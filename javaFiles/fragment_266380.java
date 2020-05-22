String measuring = "\"units\", \"kg\", \"kilogms\", \"kilo\", \"literes\", \"Liter\", \"packets\", \"packet\", \"gms\", \"grams\", \"half kg\"";
    String items = "\"Potato\", \"rice\", \"Eggs\", \"Maggi\", \"Dryfruits\", \"Maza\", \"cold drink\", \"sauce\", \"catchup\", \"coconut oil\"";
    String matching = "Kg500 Potato";//"Potato 1 kg";
    String item = "", measuringUnit = "", quantity = "";

    private void findOut() {
        String[] sMeasuringArray = measuring.replace("\"", "").split(", ");
        ArrayList<String> measuringList = new ArrayList<String>(Arrays.asList(sMeasuringArray));

        String[] sItemsArray = items.replace("\"", "").split(", ");
        ArrayList<String> itemsList = new ArrayList<String>(Arrays.asList(sItemsArray));

        String[] sMatchingArray = matching.split(" ");

        matching = matching.toUpperCase();

        for (int i = 0; i < measuringList.size(); i++) {
            if (matching.contains(measuringList.get(i).toUpperCase())) {
                measuringUnit = measuringList.get(i).trim();
                break;
            }
        }

        for (int i = 0; i < itemsList.size(); i++) {
            if (matching.contains(itemsList.get(i).toUpperCase())) {
                item = itemsList.get(i).trim();
                break;
            }
        }

        if (matching!= null) {
            String[] part = matching.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            for (int k = 0; k < part.length; k++) {
                try {
                    Integer.parseInt(part[k]);
                    quantity = part[k];
                    break;
                } catch (Exception ex) {
                    continue;
                }
            }
        }

        /*if (sMatchingArray != null) {
            if (sMatchingArray.length == 3) {
                for (int j = 0; j < sMatchingArray.length; j++) {
                    if (measuringUnit.trim().equals(sMatchingArray[j].trim())) {
                        quantity = sMatchingArray[j - 1].trim();
                        break;
                    }
                }
            } else if (sMatchingArray.length == 2) {

                String[] part = matching.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                for (int k = 0; k < part.length; k++) {
                    try {
                        Integer.parseInt(part[k]);
                        quantity = part[k];
                        break;
                    } catch (Exception ex) {
                        continue;
                    }
                }
            }
        }*/

        Log.e("Solution: ", "item = " + item + ", measuringUnit = " + measuringUnit + ", quantity = " + quantity);
    }
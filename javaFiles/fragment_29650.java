do {
            data = reader.readLine();
            String nameEntity = null;
            if (data != null) {
                String[] splitText = data.split(",");
                nameEntity = splitText[1];
            }
            if (temp != null) {
                if (data == null || !(nameEntity.equals(temp))) {
                    if (tempList.size() >= 10) {
                        for (int i = 0; i < tempList.size(); i++) {
                            newCsvBW.append(tempList.get(i));
                            newCsvBW.append("\n");
                            System.out.println(tempList.get(i));
                        }
                    }
                    tempList.clear();
                    temp = nameEntity;
                }
            } else {
                temp = nameEntity;
            }
            tempList.add(data);
        } while (data != null);
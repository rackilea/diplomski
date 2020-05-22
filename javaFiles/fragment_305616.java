for (int j = 0; j < parentList.size(); j++) {
            List<String> tempList = new ArrayList<String>();

            for (int i = 0; i < childList.size(); i++) {

                    tempList.add(childList.get(i).getChild_name());

                }
            }
            topicDataList.add(tempList);

        }
        for (int k = 0; k < parentList.size(); k++) {

            expandableListDetail.put(parentList.get(k).getChild_name(), topicDataList.get(k));
        }
return expandableListDetail;
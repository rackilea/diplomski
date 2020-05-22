Date youngestDate = null;
Date oldestDate = null;

Collections.sort(gpsDtoList, new Comparator<T>() {

            public int compare(T o1, T o2) {

                return -o1.getEreigniszeit().compareTo(o2.getEreigniszeit());

            }
        });

if (gpsDtoList != null && gpsDtoList.size() > 1) {
            youngestDate = gpsDtoList.get(0).getEreigniszeit();
            oldestDate = gpsDtoList.get(gpsDtoList.size() - 1).getEreigniszeit();
        }
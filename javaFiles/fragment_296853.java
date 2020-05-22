private static int indexOfSup(List<Supplement> supSearchList, String nameOfSup) {
        for (Supplement sup : supSearchList) {
            if (sup.getSupName().equalsIgnoreCase(nameOfSup)) {
                return supSearchList.indexOf(sup);
            }
        }
        return -1;
    }
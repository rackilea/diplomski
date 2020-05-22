for (String type: allTypes) {
        if (fData.get(type).size() > 0) {
            arraySort(fData.get(type));
            if (cData.get(type) == null) {
                temp = new ArrayList<Integer>();
                temp.add(fData.get(type).get(0).marks);
                cData.put(type, temp);
            } else {
                cData.get(type).add(fData.get(type).get(0).marks);
            }
        }
}
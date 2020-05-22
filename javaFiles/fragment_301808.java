private void sumAllCheckedAndNotify() {
        double sum = 0;
        for (int i = 0; i < checkedArr.length; i++) {
            if(checkedArr[i]) {
                sum += Double.parseDouble(catalogDatabases.get(i).getPriceItem());
            }
        }
        // pudate the listener
        listener.respond(sum, selectedCount);
    }
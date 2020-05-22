Iterator<String> iter = list.iterator();
    while (iter.hasNext()) {
        if (iter.next().equals("AA")) {
            iter.remove();
        }
    }
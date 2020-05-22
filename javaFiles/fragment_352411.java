int index = Collections.binarySearch(list, key);
    if (index < 0) {
        index = -(index + 1);
    }
    List<String> result = new ArrayList<String>();
    while (index < list.size()) {
        String s = list.get(index);
        if (s.startsWith(key)) {
            result.add(s);
        }
        else {
            break;
        }
        index++;
    }
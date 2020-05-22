public boolean hasNotEmpty(LinkedHashMap<String,ArrayList<String>> map) {
        for (ArrayList<String> list: map.values()) {
            for (String str: list)
                if (!str.equals(" "))
                    return true;
        }

        return false;
    }
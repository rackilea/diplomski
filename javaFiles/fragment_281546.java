private boolean func01 (List<String> list1, List<String> list2) {
        for (String group : list1) {
            if (list2.contains(group)) return true;
        }

        return false;
    }
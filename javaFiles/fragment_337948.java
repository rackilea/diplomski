for (String item : items) {
        String customer = item.split("\\|", 2)[0];
        customerList.add(customer);

        String log = item.substring(item.indexOf("|") + 1);
        customerHashMap.computeIfAbsent(customer, c -> new ArrayList<>()).add(log);
    }
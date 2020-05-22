for (String item : items) {
        String customer = item.split("\\|", 2)[0];
        customerList.add(customer);

        String log = item.substring(item.indexOf("|") + 1);
        List<String> logList = customerHashMap.get(customer);
        if (logList == null){
          logList = new ArrayList<>();
          customerHashMap.put(customer, logList);
        }           
        logList.add(log);
    }
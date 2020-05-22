for (Entry<Integer, String> entry: players.entrySet()){
        String value = entry.getValue();
        System.out.println(value);
        if(value.startsWith("R")){
            players.remove(entry.getKey());
            System.out.println(value+"::Contains R");
        }
}
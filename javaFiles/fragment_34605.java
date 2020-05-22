String[] personRelative = line.split(" ");
        String person = personRelative[0];
        String relative = personRelative[1];
        if(map.containsKey(person))
        {
            map.get(person).add(relative);
        }
        else
        {
            Set<String> relatives = new HashSet<String>();
            relatives.add(relative);
            map.put(person,relatives);
        }
List<Character> dups = new ArrayList<Character>();
        Iterator<String> itr = collection.iterator();
        while(itr.hasNext()) {
            String s = itr.next();
            char c = s.charAt(0);
            if(dups.contains(c)) {
                itr.remove();
                continue;
            }
            dups.add(c);
        }
        System.out.println(collection);
Scanner s = new Scanner(System.in);
    Map<Integer, Integer> map = new HashMap<>();

    while(s.hasNextLine()){
        String input = s.next();
        if (!input.equals("quit")) {
            String[] split = input.toString().split("-");
            map.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            break;
        }
    }

    for(Map.Entry<Integer,Integer> e:map.entrySet()){
        System.out.println(e.getKey()+"-"+e.getValue());
    }
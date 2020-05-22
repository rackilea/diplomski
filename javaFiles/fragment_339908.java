ArrayList<String> list = new ArrayList<>();
    list.add("Hat,45");
    list.add("Socks,15");

    for (String ss:list){
        String[] spl = ss.split(",");
        if (spl[0].equals("Hat")){
            int index = list.indexOf(ss);
            int value = Integer.parseInt(spl[1])  +10;
            list.set(index,(spl[0]+","+value));
        }
    }


    System.out.println(list);
ArrayList<String> names = new ArrayList<>();
ArrayList<String> years = new ArrayList<>();
    for(ABC item : list) {
        String[] subs = item.getDatname().split("_");
        names.add(subs[0]);
        years.add(subs[1]);
    }
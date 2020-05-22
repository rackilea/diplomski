TreeSet<Standing> standingSet = new TreeSet<Standing>();
for (String team : map2.keySet()) {
    standingSet.add(new Standing(team, map2.get(team).get(0)));
    standingSet.add(new Standing(team, map2.get(team).get(1)));
}

for (Standing standing : standingSet) {
    System.out.println(standing);
}
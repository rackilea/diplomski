Map<Integer, List<House>> groups = new HashMap<Integer, List<House>>();
for (House house:listings) {
   List<House> group = groups.get(house.getListingNum());
   if (group == null) {
     group = new ArrayList<House>();
     groups.put(house.getListingNum(), group);
   }
   group.add(house);
}

for (Entry<Integer, List<House>> entry:groups.entrySet()) System.out.println("Listing Number "+entry.getKey()+" Houses/condos: "+entry.getValue());
List<String> dailyAndSpecialList = new ArrayList<>();
List<String> sideList = new ArrayList<>();
for (int i = 0; i < dishCategory.length; i++) {
  if (dishCategory[i].equals("side Dish")) {
    sideList.add(dishes[i]);
  } else {
    dailyAndSpecialList.add(dishes[i]);
  }
}
String[] sideArray = sideList.toArray(new String[sideList.size()]);
String[] dailyAndSpecialArray = dailyAndSpecialList.toArray(new String[dailyAndSpecialList.size()]);
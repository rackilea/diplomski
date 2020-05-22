public List<RestaurantData> sort(RArrayList<RestaurantData> datas) {
  // Create a list with enough capacity for all elements
  List<RestaurantData> newList = new RArrayList<RestaurantData>(datas.size());
  Collections.copy(newList, datas);
  Collections.sort(newList, new Comparator<RestaurantData>() {
        @Override
        public int compare(RestaurantData lhs, RestaurantData rhs) {
            return lhs.getDistance() - rhs.getDistance();
        }
    });
  return newList;
}
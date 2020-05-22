public void sort(RArrayList<RestaurantData> datas) {
  Collections.sort(datas, new Comparator<RestaurantData>() {
        @Override
        public int compare(RestaurantData lhs, RestaurantData rhs) {
            return lhs.getDistance() - rhs.getDistance();
        }
    });
}
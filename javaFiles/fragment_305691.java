public void SortingHere() {
    sort(distancetos, new ToComparable<Double, Double>() {
        @Override
        public Double toComparable(Double distance) {
            // return the longitude associated with this distance
            return (Double.parseDouble(myMap1.get(distance)));
        }
    });

    for (Double distance : distancetos)
        System.out.println(distancetos);
}
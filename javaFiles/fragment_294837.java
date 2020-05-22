public static void removeLessThan(Double minimumAllowedValue, ArrayList<Double> list) {
        Double lastElement = list.get(list.size() - 1); //Assuming List is not empty and contains atleast 1 element.
        list.removeIf(element -> element < minimumAllowedValue);
        if(list.isEmpty()) {
         list.add(lastElement);
        }
}
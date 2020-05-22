public static void main(String[] args) {
    //this is just for testing. 
    ArrayList<sample_points> points = new ArrayList<>();
    points.add(new sample_points(1D, 1D));
    points.add(new sample_points(3D, 3D));
    points.add(new sample_points(5D, 5D));
    ArrayList<ArrayList<Double>> distance = distance(points);
}


public static ArrayList<ArrayList<Double>> distance(ArrayList<sample_points> points) {
    ArrayList<ArrayList<Double>> distArray = new ArrayList<>();  //here the result list

    for (int i = 0; i < points.size() - 1; i++) {   // you actually don't need the last iteration because the j-loop won't run anyway
        ArrayList<Double> distances = new ArrayList<>();  // convenience, you don't need the first loop only to populate the distArray lists
        for (int j = i + 1; j < points.size(); j++) {
            Double dist = Math.sqrt(
                    Math.pow(points.get(i).getX() - points.get(j).getX(), 2)
                            + Math.pow(points.get(i).getY() - points.get(j).getY(), 2)
            );   // do your calculations here
            distances.add(dist);   // add the distance to the current distances list
        }
        distArray.add(distances); // add the current distances list to the result list
    }
    System.out.print("Your distances: " + distArray);
    return distArray;
}
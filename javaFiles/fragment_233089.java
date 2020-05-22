//create a new GIS network and attach it to your map element
GISNetwork network = new GISNetwork(map,"myNetwork");

//add all GISPoints to this network
for(GISPoint p:locations){
    network.add(p);
}

//somehow iterate through your points to create Routes between them (here just connect one after another, no cross connections)
for(int i=0;i<locations.size()-1;i++){

    //create segment (neccessary for Curve)
    GISMarkupSegment segment = new GISMarkupSegmentLine(locations.get(i).getLatitude(), locations.get(i).getLongitude(), locations.get(i+1).getLatitude(), locations.get(i+1).getLongitude());

    //create curves (neccessary for the GISRoutes)
    Curve<GISMarkupSegment> curve = new Curve<>();

    curve.addSegment(segment);  
    curve.initialize();
    network.add(new GISRoute(map,curve,locations.get(i), locations.get(i+1), true));
}
network.initialize();
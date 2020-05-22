// Let's create an ArrayList that will contain the bouncingboxes
List<BouncingBox> boxList = new ArrayList<BouncingBox>();    

// Let's create 5 of them and add them to the end of the List
for (int ii=0;ii<5;ii++) {
    boxList.add(new BouncingBox(200, 50, Color.green));
}

// Iterate over the List we just created with the enhanced for - the method will
// be called on all objects in the List.
for (BouncingBox box : boxList) {
    box.setMovementVector(1, 1);
}
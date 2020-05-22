Random rand = new Random();
ArrayList<Draw> list = new ArrayList<Draw>();
// Add your elements here
while (!list.isEmpty()) {
    // Gets a random index in the range of the list, then removes and returns it.
    Draw elem = list.remove(rand.nextInt(list.size()));
    // Do your drawing with your random Draw elem here
}
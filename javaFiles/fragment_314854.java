[...]

  private int sAt;
  private int eAt;

  private ArrayList<Integer> path = new ArrayList<Integer>();

  [...]

  public void calculateShortestDistances(int startAt, int endAt) {

  [...]
          if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
            nodes[neighbourIndex].setDistanceFromSource(tentative);
            nodes[neighbourIndex].setPredecessor(nextNode);
          }

  [...]
  public void calculatePath(){
        int nodeNow = eAt;

        while(nodeNow != sAt){
            path.add(nodes[nodeNow].getPredecessor());
            nodeNow = nodes[nodeNow].getPredecessor();

        }

    }

    public ArrayList<Integer> getPath(){

        return path;

    }
    [...]
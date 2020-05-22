public void calcStats() {
  theWorld.initAllRanks();
  List<Entity> ancestors = new ArrayList<Entity>();
  theWorld.accumulateAllRanks(ancestors);
}

class Entity ... {
  ...

  void initAllRanks() {
    initRanks();
    for(Entity child: getChildren()) {
      child.initAllRanks();
    }
  }

  void accumulateAllRanks(List<Entity> ancestors) {
    int distance = ancestors.size();
    for(Entity ancestor: ancestors) {
      distance--;
      ancestor.addDescendant(distance, this);
    }
    ancestors.add(this); // push this
    for(Entity child: getChildren()) {
      child.accumulateAllRanks(ancestors);
    }
    ancestors.remove(ancestors.size() - 1); // pop this
  }
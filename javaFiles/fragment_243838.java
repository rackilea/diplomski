interface Worker {
    public void work()
}

class RoadWorker implements Worker {
  RoadWorker(PropertyA property) {
   this.property = property;
  }
}

void foo() {
  Worker worker = null;

  if (whichWorker.equals("road")) {
    worker = new RoadWorker(property);
  }

  worker.work();
}
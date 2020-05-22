double progressDelta = tip.getProgress() - oldProgress;
 if (tip.isMapTask()) {
    this.status.setMapProgress((float) (this.status.mapProgress() + 
                                progressDelta / maps.length));
 } else {
  this.status.setReduceProgress((float) (this.status.reduceProgress() + 
                              (progressDelta / reduces.length)));
 }
@ElementList
   public void setLayers(Collection<Layer> layers) {
      layersMap = new HashMap<>();
      for (Layer l : layers) layersMap.put(l.getId(),l);
   }        

   @ElementList
   public Collection<Layer> getLayers() {
      return layersMap.values();
   }
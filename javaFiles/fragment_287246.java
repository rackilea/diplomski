class Piece {
    ...
   @ElementList //only for solution B, for a do not use this annotation
   List<Layer> layers;

    @Transient //importatnt as it does not go into xml directly
    private Map<String, Layer> layersMap;        
}
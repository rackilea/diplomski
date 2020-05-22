class Piece {
....
@Commit
public void prepareMap() {
    layersMap = new HashMap<>();
    for (Layer l : layers) layersMap.put(l.getId(),l);
}

@Persist
public void prepareList() {
    layers = new ArrayList<>();
    layers.addAll(layersMap.values());
} 
}
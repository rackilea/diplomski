@Override
public float coord(int overlap, int maxOverlap) {
  return (overlap == maxOverlap) 
  ? 1f
  : 0.5f * super.coord(overlap, maxOverlap);
}
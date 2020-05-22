class LineColLocation {
  protected int line, col;

// constructors, setters and getters
}

ArrayList<LineColLocation> bestSpots=new ArrayList<LineColLocation>();    


int bestSpotLine=...; // ... whatever logic to ...
int bestSpotCol=...;  // determine a *best spot*

LineColLocation bestSpot=new LineColLocation(bestSpotLine, bestSpotCol);
bestSpots.add(bestSpot);
class PuzzleState extends State {
@Override
public Set<PuzzleState> findNeighbors() {
    Set<PuzzleState> set = new HashSet<PuzzleState>();
    return set;
}

public Image getImage(){
    return new PuzzleStateImage();  // implement this for Puzzle !!
}

  }



class QueensState extends State {
@Override
public Set<QueensState> findNeighbors() {
    Set<QueensState> set = new HashSet<QueensState>();
    return set;
}

public Image getImage(){
    return new QueenStateImage();  // implement this for QueenState!!
}

}


abstract class Image {
     abstract void draw();
 }

class PuzzleStateImage extends Image {
void draw() {
    // knows what/how to render PuzzleState for a visual component
}
}



class QueenStateImage extends Image {
  void draw() {
    // knows what/how to render QueenStateImage for a visual component
  }
}



interface StateDisplayable {
    Image getImage();
}

interface StateRenderer {
    void draw(Image state);
}
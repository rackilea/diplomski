// Copy constructor
public State(State state) {
    this.parent = state.parent;
    this.depth = state.depth;
    this.board = state.board;
    this.children = state.children;
    this.turn = 1 - state.turn;
    this.player1 = state.player1;
    this.player2 = state.player2;
    // shallow copy
    // this.subjects = student.subjects;

    // deep copy - create new instance of HashSet
//  this.subjects = new HashSet<>(state.subjects);
}
public class Handler implements Action{ //All the possible actions for when an action is observed

    private int wordCountWhole;

    public Handler(int number) { this.wordCountWhole = number; } 

    @Override 
    public void actionPerformed(ActionEvent event) {
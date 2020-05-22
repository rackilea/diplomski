skillButton1.addActionListener(e -> {
    // change cursor to "select" type cursor
    skill1 = true;
});

public class Mouse implements MouseListener {
    public void mouseClicked(MouseEvent e) {
         // get mouse x y
         // find target game character at x y or if none then return
         // remember the character as target
         // of skill1 of selected character
         // and count this as order complete for selected character
         skill1 = false;
         // change cursor to normal

         if (isReadyToCompute()) computeTurn();
    }
}
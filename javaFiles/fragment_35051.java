public void intialise() {

    draw.registerMouseListener(new MoueListener() {
           ....
           public void mouseClicked(MouseEvent e) {
               methodToBeCalled();                
           }
           ....
    }); 
}

public void do()
{     add(draw);    
}



int[][] arr_which_cannot_be_passed;
public void methodToBeCalled()
{
    //e can be used here
}
//other JFrame components added }
button2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        update = 1;
    }
});

public void display(GLAutoDrawable drawable) {   

    GL4 gl = (GL4) GLContext.getCurrentGL();

    if(update) {
        update = false;
        ...
    }
}
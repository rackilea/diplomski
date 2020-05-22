//Server
@Override
public void actionPerformed(ActionEvent ae)
{
    if (ae.getSource() == servertalkstogui.getCreate()/* .getButton() */)
    {
        servertalkstogui.getAreachat().append("This is the server: " + "\n");
        Thread t = new Thread(this);
        t.start();

    }

    if (ae.getSource() == servertalkstogui.getButton())
    {
        String linea = servertalkstogui.getTextField().getText();
        //servertalkstogui.getTextField().setText("");// do not clear the text here ! You don't know if it will be read yet. 

        this.writeLine(linea);
    }
}
public class Menu implements ActionListener
{
    ...

    public Menu(boolean blocked)
    {
        // this.blocked = blocked;

        ...

        startButton = createGUIButton("Resume game");
        stopButton = createGUIButton("Exit game");
        panel.add(startButton);
        panel.add(stopButton);
        // contentPane.add(panel);

        // menuWindow.validate();
        blockActionListeners(blocked); // added this line
    }

    ...

    public void blockActionEvents(boolean blocked)
    {
        this.blocked = blocked;
        if (blocked) {  // added from here...
                contentPane.remove(panel);
                menuWindow.validate();
        } else {
                contentPane.add(panel);
                menuWindow.validate();
        } // to here
    }

    ...
}
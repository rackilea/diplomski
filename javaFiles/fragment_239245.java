homePanel.add(quitButton);  // add to home panel
[...]
//salesPanel.add(quitButton); // don't add to sales panel
[...]
public void actionPerformed(ActionEvent ae){
    [...]
    if (button == salesButton)
    {   
        homePanel.remove(quitButton);
        salesPanel.add(quitButton);
        [...]
    }
    else if (button  == homeButton)
    {
        salesPanel.remove(quitButton);
        homePanel.add(quitButton);
        [...]
    }
    [...]
}
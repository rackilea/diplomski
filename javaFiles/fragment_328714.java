//make it a sub class of JPanel for easier implementation. 
public class Cell extends JPanel{

    public  Cell(){

        JPanel firstPanel = new JPanel();
        //add a lable just so something is displayed
        firstPanel.add(new JLabel(("Panel 1"))); 
        JPanel secondPanel = new JPanel();
        JPanel thridpanel = new JPanel();

        CardLayout cardLayout = new CardLayout();
        /* assign the card layout */
        setLayout(cardLayout);

        /* add the different panels to the container panel and show the initial one */
        add(firstPanel, "firstPanel");
        add(secondPanel, "secondPanel");
        add(thridpanel, "thridpanel");
        cardLayout.show(this, "firstPanel");
    }
}
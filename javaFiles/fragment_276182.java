// Start the window in the EDT. 
public void start() {   
    showWindow(); 
    controller.start();  
} 

// Defines the general properties of and starts the window. 
public void showWindow() { 
    frame = new JFrame("Game"); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    frame.setSize(600,400); 
    frame.setVisible(true); 
} 

// The thread controlling changes of panels in the main window. 
private Thread controller = new Thread() { 
    public void run() { 

        // some long running process, I assume, but at 
        // some point you want to update UI:
        SwingUtilities.invokeLater(new Runnable() { 
            public void run() { 
                frame.add(generatePartnerSelectionPanel()); 
                frame.invalidate(); 
                frame.validate(); 
            } 
        });
    } 
};
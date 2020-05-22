Robot robot = new Robot();//throws AWTException

...

Component[] components=getContentPane().getComponents();  

for(int i=0;i<components.length;i++)  
{
    if(components[i] instanceof JTextArea) { 
         components[i].requestFocusInWindow();
         simulateEnter();
     }
}

public static void simulateEnter() {
     robot.keyPress(KeyEvent.VK_ENTER);
     robot.keyRelease(KeyEvent.VK_ENTER);
}
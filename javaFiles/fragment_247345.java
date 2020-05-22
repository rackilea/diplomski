public class MainBar extends WebMenuBar{

public  MainBar() { 


// Bar Menu
final WebMenuBar mainBar = new WebMenuBar();
mainBar.setMenuBarStyle(MenuBarStyle.standalone);

// Bar Menu Items
JMenu fileMenu = new JMenu("File");
JMenuItem exitMenuItem = new JMenuItem("Exit");
fileMenu.add(exitMenuItem);

JMenu editMenu = new JMenu("Edit");
JMenuItem cutMenuItem = new JMenuItem("Cut");
editMenu.add(cutMenuItem);
JMenuItem copyMenuItem = new JMenuItem("Copy");
editMenu.add(copyMenuItem);

JMenu viewMenu = new JMenu("View");
JMenu settingsMenu = new JMenu("Settings");
JMenu helpMenu = new JMenu("Help");

// adding menu items to bar menu
add(fileMenu);
add(editMenu);
add(viewMenu);
add(settingsMenu);
add(helpMenu);


}
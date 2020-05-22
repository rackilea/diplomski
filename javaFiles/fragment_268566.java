import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.SWT;
....
              //These 3 lines are the solution for style, turns out to be simple.
                Image image = <<Your image for deselected>>;
                ToolItem item = = new ToolItem(toolBar, SWT.BEGINNING | SWT.DROP_DOWN);
                item.setImage(image);
              //Menu creation for arrow
                Menu menu = new Menu(item.getParent().getShell());
                new MenuItem(menu, SWT.PUSH).setText("Menu item example 1");
              //Indication for state of button press (to give it checkbox behavior - does not have to be atomic)
                AtomicBoolean recording = new AtomicBoolean(false);
              //This is where the logic is for opening the menu and enabling a checkbox behavior 
              //is done. ((width * 3) was added because tool bar is on the side for my specific use case)
                item.addListener(SWT.Selection, e -> {
                                if (e.detail == SWT.ARROW) {
                                    Rectangle rect = item.getBounds();
                                    Point pt = new Point(rect.x - (rect.width * 3), rect.y + rect.height);
                                    pt = toolBar.toDisplay(pt);
                                    menu.setLocation(pt.x, pt.y);
                                    menu.setVisible(true);
                                } else {
                                   //logic for pressing icon. You can swap the icon 
                                   //image according to needed with item.setImage()
                                }
                            });
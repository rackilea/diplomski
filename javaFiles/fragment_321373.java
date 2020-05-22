import java.lang.reflect.InvocationTargetException;  
import java.awt.event.MouseAdapter;  
import java.lang.reflect.Field;  
import javax.swing.*;  
import javax.swing.plaf.basic.BasicComboPopup;  
import javax.swing.plaf.basic.BasicComboBoxUI;  
import java.awt.event.MouseEvent;  

/** 
 * User: destiny 
 * Date: Oct 19, 2009 
 * Time: 9:18:34 PM 
 */  
public class JComboPopupMouseListenerDemo {  

    private static void addPopupMouseListener(JComboBox box) {  
        try {  
                  Field popupInBasicComboBoxUI = BasicComboBoxUI.class.getDeclaredField("popup");  
                popupInBasicComboBoxUI.setAccessible(true);  
                BasicComboPopup popup = (BasicComboPopup) popupInBasicComboBoxUI.get(box.getUI());  

                Field scrollerInBasicComboPopup = BasicComboPopup.class.getDeclaredField("scroller");  
                scrollerInBasicComboPopup.setAccessible(true);  
                JScrollPane scroller = (JScrollPane) scrollerInBasicComboPopup.get(popup);  

                scroller.getViewport().getView().addMouseListener(this);  
//                ((JViewport) ((JScrollPane) ((BasicComboPopup) popupInBasicComboBoxUI.get(box.getUI())).getComponents()[0]).getComponents()[0]).getComponents()[0].addMouseListener(this);  
        }  
        catch (NoSuchFieldException e) {  
            e.printStackTrace();  
        }  
        catch (IllegalAccessException e) {  
            e.printStackTrace();  
        }  
    }  

    private static MouseAdapter listener() {  
        return new MouseAdapter(){  
            public void mouseClicked(MouseEvent mouseEvent) {  
                System.out.println("mouseClicked");  
            }  

            public void mousePressed(MouseEvent mouseEvent) {  
                System.out.println("mousePressed");  
            }  

            public void mouseReleased(MouseEvent mouseEvent) {  
                System.out.println("mouseReleased");  
            }  

            public void mouseEntered(MouseEvent mouseEvent) {  
                System.out.println("mouseEntered");  
            }  

            public void mouseExited(MouseEvent mouseEvent) {  
                System.out.println("mouseExited");  
            }  
        };  
    }  

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {  
        JComboBox box = new JComboBox(new String[]{"val 1","val 2","val ......","val 4","val 5","val 6"});  
        box.setEditable(true);  
        addPopupMouseListener(box);  

        JFrame frame = new JFrame();  
        frame.add(box);  
        frame.pack();  
        frame.setVisible(true);  
    }  
}
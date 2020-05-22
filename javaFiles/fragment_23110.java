import java.awt.Window;
import javax.swing.Action;

public interface MvcView {

   void setVisible(boolean visible);

   void setFileAction(Action fileAction);

   void setOpenFileAction(Action openFileAction);

   void setSaveToFileAction(Action saveToFileAction);

   void setExitAction(Action exitAction);

   void setStatusText(String string);

   String getTextAreaText();

   void setTextAreaText(String text);

   Window getTopWindow();

}
import java.awt.EventQueue;
import java.awt.Color;

public static void changeColor(final String screenId, final String componentId, 
                               final Color color, final Context context) 
{
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            FormEnvironment formEnvironment = 
               ((FormPanelContainer)context.getScreenById(screenId)).getFormEnvironment();
            JComponent label = (JComponent)formEnvironment.getFormComponentById(componentId).
                getConfigurationObject();
            label.setForeground(color);
        }
    });
}
import java.awt.EventQueue;
import java.awt.Color;

EventQueue.invokeLater(new Runnable() {
    public void run() {
        FormEnvironment formEnvironment = 
            ((FormPanelContainer)context.getScreenById("screenId")).getFormEnvironment();
        JComponent label = (JComponent)formEnvironment.getFormComponentById("componentId").
             getConfigurationObject();
        label.setForeground(Color.MAGENTA);
    }
});
return true;
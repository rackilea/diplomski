import org.eclipse.e4.ui.internal.workbench.swt.E4Application;

import org.eclipse.swt.graphics.DeviceData;
import org.eclipse.swt.widgets.Display;

public class MyApplication extends E4Application
{
  /** Enable tracking */
  private static final boolean TRACKING = true;
  /** Enable debug */
  private static final boolean DEBUG = false;

  public MyApplication()
  {
    super();
  }

  @Override
  public Display getApplicationDisplay()
  {
    Display current = Display.getCurrent();
    if (current == null)
     {
       if (TRACKING || DEBUG)
        {
          DeviceData data = new DeviceData();
          data.tracking = TRACKING;
          data.debug = DEBUG;

          current = new Display(data);

          if (data.tracking)
           {
             Sleak sleak = new Sleak();
             sleak.open();
           }
        }
       else
        {
          current = new Display();
        }
     }

    return super.getApplicationDisplay();
  }
}
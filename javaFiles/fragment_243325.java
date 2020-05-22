import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

public class CompositeToWrite extends Composite
{
  private int   width, height;

  private Label l;

  public CompositeToWrite(Composite parent, int style)
  {
    super(parent, style);
    this.setLayout(new GridLayout(1, true));
    this.addListener(SWT.Resize, new Listener()
    {

      @Override
      public void handleEvent(Event event)
      {
        updateText();
      }
    });

    Button b = new Button(this, SWT.NONE);
    b.setText("Export as image (500, 500)");
    b.addListener(SWT.Selection, new Listener()
    {

      @Override
      public void handleEvent(Event event)
      {
        CompositeImageWriter.drawComposite("./img/output.png", CompositeToWrite.this, 500, 500,
            SWT.IMAGE_PNG);
      }
    });

    l = new Label(this, SWT.CENTER);
    GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
    gd.verticalAlignment = SWT.CENTER;
    l.setLayoutData(gd);
    updateText();
  }

  protected void updateText()
  {
    width = this.getBounds().width;
    height = this.getBounds().height;

    l.setText("My label is centered in composite (" + width + ", " + height + ")");
  }

}
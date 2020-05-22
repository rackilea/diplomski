import java.lang.reflect.Method;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;

public class BoundedLayout extends Layout {
  protected Layout delegateLayout;

  protected Method computeSizeMethod;
  protected Method layoutMethod;

  protected boolean widthBound;

  public BoundedLayout(Layout delegateLayout, boolean widthBound) {
      setDelegateLayout(delegateLayout);
      this.widthBound = widthBound;
  }

  public Layout getDelegateLayout() {
      return delegateLayout;
  }

  public void setDelegateLayout(Layout delegateLayout) {
      this.delegateLayout = delegateLayout;

      try {
          computeSizeMethod = delegateLayout.getClass().getDeclaredMethod(
                "computeSize", Composite.class, int.class, int.class,
                boolean.class);
          computeSizeMethod.setAccessible(true);

          layoutMethod = delegateLayout.getClass().getDeclaredMethod(
                "layout", Composite.class, boolean.class);
          layoutMethod.setAccessible(true);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
  }

  @Override
  protected Point computeSize(Composite composite, int wHint, int hHint,
        boolean flushCache) {
    // get comp size to make sure we don't let any children exceed it
    Point compSize = composite.getSize();

    try {
        Point layoutComputedSize = (Point) computeSizeMethod.invoke(
                delegateLayout, composite, wHint, hHint, flushCache);

        if (widthBound) {
            layoutComputedSize.x = Math.min(compSize.x,
                    layoutComputedSize.x);
        } else {
            layoutComputedSize.y = Math.min(compSize.y,
                    layoutComputedSize.y);
        }

        return layoutComputedSize;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
  }

  @Override
  protected void layout(Composite composite, boolean flushCache) {
    try {
        layoutMethod.invoke(delegateLayout, composite, flushCache);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
  }
}
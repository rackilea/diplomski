public class TableItemPaintListener implements Listener{    
 public void handleEvent(Event event) {
     switch (event.type) {
              case SWT.MeasureItem: {
                  TableItem item = (TableItem) event.item;
                  String text = item.getText();
                  Point size = event.gc.textExtent(text);
                  event.width = size.x;
                  event.height = Math.max(event.height, size.y);
                  break;
            }    
         }
     }
}
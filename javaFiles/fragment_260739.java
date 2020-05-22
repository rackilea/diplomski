public class BalloonOverlayView{
 List<OverlayItem> items = null;
 public BalloonOverlayView(List<OverlayItem> items){
    this.items = items;
 }
 // Now you can use the ItemizedOverlay class from within this class as you wish
 public void addItem(OverlayItem item){
    items.add(item);
 }
 public void removeItem(OverlayItem item){
    item.remove(item);
 }
}
public class CustomListRow extends Manager implements FieldChangeListener {

   private static final int _MAX_ROW_HEIGHT = 60;   
   private ListRander _data;
   private BitmapField _thumb;
   private LabelField _title;
   private FocusableBitmapField _star;
   private static final Bitmap _starImg = Bitmap.getBitmapResource("star.png");
   private static final Bitmap _bgImg = Bitmap.getBitmapResource("listing_bg.png");
   private SeparatorField _separator;
   private int _fontColor = Color.BLACK;
   private boolean _highlighted = false;
   private int _width;

   // subclass exists to expose focus methods (make public)
   private class FocusableBitmapField extends BitmapField {
      public FocusableBitmapField() {
         super(_starImg, BitmapField.FOCUSABLE | BitmapField.EDITABLE);    
      }
      public void onFocus(int direction) {
         super.onFocus(direction);
      }
      public void onUnfocus() {
         super.onUnfocus();
      }
   }

   public CustomListRow(ListRander data) {
      super(Field.FOCUSABLE | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);

      setBackground(BackgroundFactory.createBitmapBackground(_bgImg));
      _width = Display.getWidth();

      long labelStyle = (DrawStyle.LEFT | DrawStyle.TOP | DrawStyle.ELLIPSIS);
      _title = new LabelField("", labelStyle) {   // custom anonymous class to change font color
         protected void paint(Graphics g) {
            int c = g.getColor();
            g.setColor(_fontColor);
            super.paint(g);
            g.setColor(c);
         }
      };
      _title.setFont(Font.getDefault().getFontFamily().getFont(Font.PLAIN, 24));

      _thumb = new BitmapField();

      _star = new FocusableBitmapField();
      _star.setChangeListener(this);

      _separator = new SeparatorField() {  // custom anonymous class to change separator color
         protected void paint(Graphics g) {
            int c = g.getColor();
            g.setColor(Color.GRAY);
            super.paint(g);
            g.setColor(c);
         }
      };

      setData(data);

      add(_thumb);
      add(_title);
      add(_star);
      add(_separator);
   }

   public ListRander getData() {
      return _data;
   }

   public void setData(ListRander value) {
      if (value != _data) {
         _data = value;

         _title.setText(value.getTitle());
         _thumb.setBitmap(value.getThumb());
      }
   }

   private void onStarClicked() {
      Dialog.alert("Star has been clicked or tapped!");
   }

   private void onRowClicked() {
      Dialog.alert("Row has been clicked or tapped!");
   }

   public void fieldChanged(Field field, int context) {
      if (field == _star) {
         onStarClicked();
      }
   }  

   public boolean navigationClick(int status, int time) {
      if (_star.isFocus()) {
         onStarClicked();
         return true;
      } /* else {
            onRowClicked();
            return true;
        } */
      return false;  // we will not consume this event
   }

   protected void highlight(boolean onRow) {
      _fontColor = onRow ? Color.WHITE : Color.BLACK;  // change font color for contrast
      _highlighted = onRow;         
      invalidate();
   }

   protected void onFocus(int direction) {
      // called when focus first transfers to this row, from another Field
      if (direction == 1) {
         // coming from top to bottom, we highlight the row first, not the star  
         highlight(true);
      } else if (direction == -1) {
         // coming from bottom to top, we highlight the star button first, not the row
         _star.onFocus(direction);
         highlight(false);
      }
   }  

   protected void onUnfocus() {
      // remove highlighting of the row, if any
      highlight(false);
      super.onUnfocus();
   }

   protected int moveFocus(int amount, int status, int time) {
      // called when this row already has focus (either on row, or star button)
      if (amount > 0) {
         // moving top to bottom
         if (!_star.isFocus()) {
            // we were on the row, now move to the star button
            _star.onFocus(1);
            highlight(false);
            amount--;             // consume one unit of movement
         }
      } else {
         // moving from bottom to top
         if (_star.isFocus()) {
            // we were on the star button, now move back over to the row
            _star.onUnfocus();
            highlight(true);
            amount++;             // consume one unit of movement
         }
      }
      return amount;
   }

   protected boolean touchEvent(net.rim.device.api.ui.TouchEvent event) {
      // We take action when the user completes a click (a.k.a. unclick)
      int eventCode = event.getEvent();
      if ((eventCode == TouchEvent.UNCLICK) || (eventCode == TouchEvent.DOWN)) {
         // Get the touch location, within this Manager
         int x = event.getX(1);
         int y = event.getY(1);

         if ((x >= 0) && (y >= 0) && (x < _width) && (y < _MAX_ROW_HEIGHT)) {
            int field = getFieldAtLocation(x, y);
            if ((field >= 0) && (getField(field) == _star)) {
               // Let event propagate to (star) button field
               return super.touchEvent(event);
            } else {
               if (eventCode == TouchEvent.UNCLICK) {
                  // A completed click anywhere else in this row should popup details for this selection
                  fieldChangeNotify(1);
                  onRowClicked();
               } else {
                  // This is just a soft touch (TouchEvent.DOWN), without full click
                  setFocus();
               }
               // Consume the event
               return true;
            }
         }
      }
      // Event wasn't for us, let superclass handle in default manner
      return super.touchEvent(event);
   }

   protected void sublayout(int width, int height) {
      height = Math.min(getPreferredHeight(), height);
      setExtent(_width, height);

      final int margin = 5;

      int thumbWidth = _thumb.getPreferredWidth();
      layoutChild(_thumb, thumbWidth, _thumb.getPreferredHeight());
      setPositionChild(_thumb, margin, margin);

      int starWidth = _star.getPreferredWidth();
      int starHeight = _star.getPreferredHeight();
      layoutChild(_star, starWidth, starHeight);
      setPositionChild(_star, width - starWidth - margin, (height - starHeight) / 2);

      // this assumes you want margin between all fields, and edges
      layoutChild(_title, width - thumbWidth - starWidth - 4 * margin, _title.getPreferredHeight());
      setPositionChild(_title, margin + thumbWidth /* + margin */, margin);  // TODO?
   }    

   protected void paintBackground(Graphics g) {
      super.paintBackground(g);
      if (_highlighted) {
         // you can't override drawFocus() for a Manager, so we'll handle that here:
         int oldColor = g.getColor();
         int oldAlpha = g.getGlobalAlpha();
         XYRect rect = new XYRect();
         g.setGlobalAlpha(150); 
         g.setColor(Color.BLUE); 
         getFocusRect(rect); 
         drawHighlightRegion(g, HIGHLIGHT_FOCUS, true, rect.x, rect.y, rect.width, rect.height);
         g.setGlobalAlpha(oldAlpha);
         g.setColor(oldColor);
      }
   }

   public int getPreferredWidth() {
      return _width;
   }

   public int getPreferredHeight() {
      return _MAX_ROW_HEIGHT;
   }
}
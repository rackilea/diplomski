public class CustomListField extends Manager implements FocusChangeListener {

   private int _MAX_ROW_HEIGHT = 60; 
   private boolean _searchable = false;
   private Vector _listData; 
   private FieldChangeListener _fieldListener;

   public CustomListField(Vector data) {
      super(FOCUSABLE | VERTICAL_SCROLL | VERTICAL_SCROLLBAR);
      setSearchable(true);
      setEditable(false);
      setListData(data);
   }

   public void setChangeListener(FieldChangeListener listener) {
      // we need to save this listener, because we set it to listen to all new rows
      _fieldListener = listener;
      int numFields = getFieldCount();
      for (int f = 0; f < numFields; f++) {
         getField(f).setChangeListener(listener);
      }
      super.setChangeListener(listener);
   }

   public int getRowHeight() {
      return _MAX_ROW_HEIGHT;
   }

   public void setSearchable(boolean searchable) {
      _searchable = searchable;
   }

   public int getSelectedIndex() {
      return getFieldWithFocusIndex();  // TODO??
   }

   public Object get(int index) {
      return _listData.elementAt(index);
   }

   public int indexOfList(String prefix, int start) {
      if (start >= _listData.size() || !_searchable) {
         return -1;
      } else {
         int result = getSelectedIndex();  // the default result if we find no matches
         for (Enumeration e = _listData.elements(); e.hasMoreElements(); ) {
            String rowString = (String) e.nextElement(); 
            if (rowString.startsWith(prefix)) { 
               return _listData.indexOf(rowString); 
            } 
         }
         return result;
      }
   }

   protected boolean navigationClick(int status, int time) {
      CustomListRow focus = (CustomListRow) getFieldWithFocus();
      if (focus != null) {
         // see if the row wants to process this click
         if (!focus.navigationClick(status, time)) {
            // let our FieldChangeListener know that this row has been clicked
            fieldChangeNotify(getFieldWithFocusIndex());
         }
         return true;
      } else {
         return false;
      }
   }

   protected void sublayout(int width, int height) {
      int w = Math.min(width, getPreferredWidth());
      int h = Math.min(height, getPreferredHeight());
      int rowHeight = getRowHeight();
      int numRows = getFieldCount();

      setExtent(w, h);
      setVirtualExtent(w, rowHeight * numRows);

      for (int i = 0; i < numRows; i++) {
         Field f = getField(i);
         setPositionChild(f, 0, rowHeight * i);
         layoutChild(f, w, rowHeight);
      }
   }

   public int getPreferredWidth() {
      return Display.getWidth();
   }

   public int getPreferredHeight() {
      return Display.getHeight();
   }

   public void setListData(Vector listData) {
      _listData = listData;
      if (listData != null) {
         int listSize = listData.size();
         int numRows = getFieldCount();
         for (int s = 0; s < listSize; s++) {
            if (s < numRows) {
               // we can reuse existing CustomListRows
               CustomListRow row = (CustomListRow) getField(s);               
               row.setData((ListRander) listData.elementAt(s));
            } else {
               CustomListRow row = new CustomListRow((ListRander) listData.elementAt(s));
               row.setChangeListener(_fieldListener);
               row.setFocusListener(this);
               add(row);
            }
         }

         if (listSize < numRows) {
            // delete the excess rows
            deleteRange(listSize, numRows - listSize);
         }
      } else {
         deleteAll();
      }
      invalidate();
   }

   public void focusChanged(Field field, int eventType) {
      // we handle scrolling here, when focus changes between rows
      if (eventType == FOCUS_GAINED) {
         if (field.getTop() < getVerticalScroll()) {
            // field is off the top of the screen, so scroll up
            setVerticalScroll(field.getTop());
         } else if (field.getTop() >= getVerticalScroll() + getVisibleHeight()) {
            // field is off the bottom of the screen, so scroll down
            setVerticalScroll(field.getTop() - getVisibleHeight() + getRowHeight());
         }          
      }
   }
}
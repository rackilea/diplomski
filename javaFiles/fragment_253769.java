public static List<Object> asList(final DefaultListModel model) {
     return new AbstractList<Object>() {
          @Override public Object get(int index) {
              return        model.getElementAt(index);
          }
          ...
     };
 }
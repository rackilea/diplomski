HighlightPredicate feverWarning = new HighlightPredicate() {
         int temperatureColumn = 10;

         public boolean isHighlighted(Component component, ComponentAdapter adapter) {
             return hasFever(adapter.getValue(temperatureColumn));
         }

         private boolean hasFever(Object value) {
             if (!value instanceof Number)
                 return false;
             return ((Number) value).intValue() &gt; 37;
         }
     };

     Highlighter hl = new ColorHighlighter(feverWarning, Color.RED, null);
     table.addHighlighter(hl);
ColumnConfig<Stock, Double> changeCol = new ColumnConfig<Stock, Double>(props.change(), 100, "Change");
      changeCol.setCell(new AbstractCell<Double>() {

   @Override
   public void render(Context context, Double value, SafeHtmlBuilder sb) {
      String style = "style='color: " + (value < 0 ? "red" : "green") + "'";
      String v = number.format(value);
      sb.appendHtmlConstant("<span " + style + " qtitle='Change' qtip='" + v + "'>" + v + "</span>");
   }
});
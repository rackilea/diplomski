grid
  .addColumn(Stock::getValue1)
  .setCaption("Value1")
  .setStyleGenerator(stockRow -> {
    switch (stockRow.getValue1()) {
      case "1": return "red";
      case "3": return "yellow";
      case "5": return "green";
      default: return null;
    }
  });
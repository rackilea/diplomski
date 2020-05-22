static class CustomLabelGenerator implements PieSectionLabelGenerator {
  private final CategoryDataset catDataset;

  public CustomLabelGenerator(CategoryDataset catDataset) {
    this.catDataset = catDataset;
  }

  public String generateSectionLabel(PieDataset dataset, Comparable key) {
    int column = 0;
    for (int c = 0; c < catDataset.getColumnCount(); c++) {
      CategoryToPieDataset categoryToPieDataset = 
          new CategoryToPieDataset(catDataset, TableOrder.BY_COLUMN, c);
      if (categoryToPieDataset.equals(dataset)) {
        column = c;
        break;
      }
    }
    NumberFormat nf;
    switch (column) {
      case 0: // the 'Sales Quantity' column
        nf = new DecimalFormat("#,##0");
        break;
      case 1: // the 'Sales Total' column
        nf = new DecimalFormat("$ #,##0.00");
        break;
      default:
        throw new IllegalStateException("Invalid column. This is impossible");
    }
    return nf.format(dataset.getValue(key));
  }
}
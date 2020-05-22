createPdf() {

  for (Expense expense : db.getSepficItem()) {
    // ..
    table.addCell(expense.getId());
  }
}
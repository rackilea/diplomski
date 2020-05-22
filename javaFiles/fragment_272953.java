for (int i = 0; i < stockList.size(); i++) {
  Stock stok = stockList.get(i);
  StockOpenAndClose openStk = stockOpenCloseList.get(i);
  StockHistory stkHis = stkHisList.get(i);
  session.saveOrUpdate(stok);
  session.flush();

  openStk.setStock_id(stok.getStock_id());
  session.save(openStk);

  stkHis.setStock_id(stok.getStock_id());
  session.saveOrUpdate(stkHis);
  session.flush();
}
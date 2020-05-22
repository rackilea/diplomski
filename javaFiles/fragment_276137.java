session.beginTransaction();
session.setFlushMode(FlushMode.ALWAYS );
for (int i = 1; i < 4; i++) {
    Stock stock = new Stock();
    stock.setStockId(i);
    stock.setStockCode("code-"+i);
    stock.setStockName("name-"+i);
    session.save(stock);
    System.out.println("entity saved");
}
session.getTransaction().commit();
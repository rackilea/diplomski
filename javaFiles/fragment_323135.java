public StockCategory getStockCategory(StockCategoryId id) throws RecordNotFoundException
{   
    StockCategory stock_category = 
      (StockCategory)getCurrentSession().get(StockCategory.class, id);

    return stock_category;
}
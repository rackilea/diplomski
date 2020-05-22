try{
      quoteLineDao.delete(new Long(44));
      System.out.println("°°°°°°°°°°°°°°°°°°Line 44 deleted");
      return  quoteDao.save(quote); 
} catch(Exception e){
      Logger.getLogger(QuoteService.class).log(Logger.Level.ERROR, e);
      throw e;
}
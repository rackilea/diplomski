(SearchResult<? extends ItemModel>) sessionService.executeInLocalView(new SessionExecutionBody()
{
   @Override
   public Object execute() 
   {
     sessionService.setAttribute(FlexibleSearch.DISABLE_RESTRICTIONS, Boolean.TRUE);
     return flexibleSearchService.search(query);
   }
});
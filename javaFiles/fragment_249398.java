public abstract class Filter{

     /** Member identifier for the current page number */
     private int currentPageNo;

     /** Member identifier for the current start page number in the page navigation */
     private int currentStartPageNo;

     /** Member identifier for the current end page number in the page navigation */
     private int currentEndPageNo;

     /** Member identifier for the number of elements on a page */
     private int elementsPerPage;

     /** Member identifier for the number of pages you have in the navigation (i.e 2 to  11 or 3 to 12 etc.) */      
     private int pageNumberInNavigation;

     public abstract Query createCountQuery();

     public abstract Query createQuery();

     public void setCurrentPageNo(){
         //Your code here
         //Validation, variable setup
     }

     public Long getAllElementsCount(){
          //Now this depends on the presistence framework you use, this code is
          //just for guidance and has Hibernate-like syntax
          Query query = createCountQuery();
          List list = query.list();
          return !list.isEmpty() && list.get(0) != null ? query.list().get(0) : 0;
     }

     public List getElements(){
          //Now this depends on the presistence framework you use, this code is
          //just for guidance and has Hibernate-like syntax
         Query query = createQuery();
         int from = ((currentPageNo - 1) * elementsPerPage);
         query.setFirstResult(from);
         query.setMaxResults(elementsPerPage);
         //If you use Hibernate, you don't need to worry for null check since if there are no results then an empty collection is returned
         return query.list();
     }

     public List getAllElements(){
         Query query = createQuery();
         return query.list();
     }

     public void refresh(){
         //Your code here
     }

     public List next(){
         //Move to the next page if exists
         setCurrentPageNo(getCurrentPageNo() + 1);
         getElements();
     }

     public List previoius(){
         //Move to the previous page if exists
         setCurrentPageNo(getCurrentPageNo() - 1);
         getElements();
     }

}
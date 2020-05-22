public DataTablePage extends Page {
      private DataTable dataTable;
      public void setDataTablePage(int page){
            dataTable.setCurrentPage(page);
      }   
      // .....
     // DataTable cell link onclick
     public void onClick(){
         int pageNumber = dataTable.getCurrentPage();
         DetailPage detailPage = new DetailPage(id, params, pageNumber);
         setResponsePage(page);
     }          
 }

 public class DetailPage extends Page {
     int pageNumber;
     public DetailPage(String id, Object params, int pageNumber){
         //...
         this.pageNumber = pageNumber;
         //...
     }
     private void backToTablePage(){
          DataTablePage dataTablePage = new DataTablePage(id, params);
          dataTablePage.setDataTablePage(pageNumber);
          setResponsePage(dataTablePage);
     }
 }
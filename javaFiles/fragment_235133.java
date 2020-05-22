public class MyActionTest {
   private MyService service = mock(MyService.class);
   private MyAction action = new MyAction(){
       @Override
       MyService getMyService() {return service;}
   };

    @Test
    public void testSearch() throws Exception{

        List<MyList> list = new ArrayList<MyList>();
        when(service.getRecords(searchRequest)).thenReturn(list);
        ActionForward forward = action.search(mapping, form, request, response);        
    }

}
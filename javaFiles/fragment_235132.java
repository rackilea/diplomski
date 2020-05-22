public class MyAction{
        public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
            MyService service = getMyService();
            **form.setList(service.getRecords(searchRequest));**
        }
        MyService getMyService() {
          return new MyClass();
        }

    }
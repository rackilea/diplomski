@Component  
public class ExceptionHandler extends ExceptionHandlerExceptionResolver{
        @Autowired
        ApplicationContext context;

        @Override
        public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {

            TestException exception=null;
            if (ex instanceof DataAccessException) {
                exception = new TestException(context.getMessage("SQLException",
                        null, null));
            } else if (ex instanceof SQLException) {
                exception = new TestException(context.getMessage("SQLException",
                        null, null));
            } else if (ex instanceof java.net.UnknownHostException) {
                exception = new TestException(context.getMessage(
                        "UnknownHostException", null, null));
            } else if (ex instanceof IOException) {
                exception = new TestException(context.getMessage("IOException",
                        null,null));
            } else if (ex instanceof Exception) {
                exception = new TestException(context.getMessage("Exception",
                        null, null));
            } else if (ex instanceof Throwable) {
                exception = new TestException(context.getMessage("Throwable",
                        null, null));
            }



            if( isAjax(request) ) {
             return exception.asModelAndView();
           } 
            else
            {  ModelAndView modelAndView = new ModelAndView("TestExceptionPage");

            modelAndView.addObject("exception", exception);
            return modelAndView;
            }
        }
        private boolean isAjax(HttpServletRequest request) {
            return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
        }





    }
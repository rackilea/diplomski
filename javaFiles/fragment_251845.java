public class CustomizedViewResolver extends UrlBasedViewResolver {
        @Override
        protected AbstractUrlBasedView buildView(String viewName) throws Exception {
            String newViewName;
            if(viewName.equals("YourLegacyCodeViewName")){
                newViewName = "ViewNameYouWantToRedirect";
            }else{
                newViewName = viewName;
            }
            return super.buildView(newViewName);
        }
    }
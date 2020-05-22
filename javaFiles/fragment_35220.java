public class CallFromJavascriptBehavior extends AbstractDefaultAjaxBehavior {
   @Override
   protected void respond(AjaxRequestTarget target) {
      final StringValue parameterValue = RequestCycle.get().getRequest().getQueryParameters().getParameterValue("yourName");
      System.out.println(String.format("Hello %s", parameterValue.toString()));

      // write anything to the WebResponse and then consume it in the JS success handler. See below
   }

   @Override
   public void onComponenntTag(ComponenntTag tag, Component component) {
       super.onComponenntTag(tag, component);
       tag.put("data-the-url", getCallbackUrl());
   }
}
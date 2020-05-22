public class ModalTestPage extends WebPage {
    public ModalTestPage(PageParameters parameters) {
        super(parameters);

        final ModalWindow modal = new ModalWindow("modal");
        modal.setContent(new Fragment(modal.getContentId(), "window", this));
        add(modal);

        add(new AjaxLink<Void>("link") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                modal.show(target);
            }
        });

        add(new CloseOnESCBehavior(modal));
    }

    private static class CloseOnESCBehavior extends AbstractDefaultAjaxBehavior {
        private final ModalWindow modal;
        public CloseOnESCBehavior(ModalWindow modal) {
            this.modal = modal;
        }    
        @Override
        protected void respond(AjaxRequestTarget target) {
            modal.close(target);
        }    
        @Override
        public void renderHead(Component component, IHeaderResponse response) {
            response.renderJavaScriptReference("https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js");
            response.renderJavaScript("" +
                "$(document).ready(function() {\n" +
                "  $(document).bind('keyup', function(evt) {\n" +
                "    if (evt.keyCode == 27) {\n" +
                getCallbackScript() + "\n" +
                "        evt.preventDefault();\n" +
                "    }\n" +
                "  });\n" +
                "});", "closeModal");
        }
    }
}
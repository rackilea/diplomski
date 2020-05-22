button.addClickHandler(new ClickHandler() {
public void onClick(ClickEvent arg0) {

    exlGenerationServiceAsync.excelReportObjects(new AsyncCallback() {

                        @Override
                        public void onFailure(Throwable arg0) {
                            arg0.printStackTrace();
                        }

                        @Override
                        public void onSuccess(Object arg0) {
                            Window.open(GWT.getModuleBaseURL() + "url", "", "");
                        }
                    });

                }
}
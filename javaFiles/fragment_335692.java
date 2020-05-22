private Form<CriteriaBean> helpCreateCriteriaForm() {
            return new Form<CriteriaBean>(LocationPage.CRITERIA_FORM_ID) {
                @Override
                protected void onSubmit() {
                    invokeMe();
                }
            };
        }
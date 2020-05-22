final Form<?> form = new Form("form");
    add(form);

    IModel<Date> dateModel = Model.of();
    DateTimeField dateTimeField = new DateTimeField("dateTimeField", dateModel) {

        @Override
        protected DateTextField newDateTextField(String id, PropertyModel dateFieldModel) {
            DateTextField dateField = super.newDateTextField(id, dateFieldModel);
            dateField.add(new AjaxFormSubmitBehavior(form, "change") {
            });
            return dateField;

        }

        @Override
        protected TextField<Integer> newMinutesTextField(String id, IModel<Integer> model, Class<Integer> type) {
            TextField<Integer> textField = super.newMinutesTextField(id, model, type);
            textField.add(new AjaxFormSubmitBehavior(form, "change") {
            });

            return textField;
        }

        @Override
        protected TextField<Integer> newHoursTextField(final String id, IModel<Integer> model, Class<Integer> type) {
            TextField<Integer> textField = super.newHoursTextField(id, model, type);
            textField.add(new AjaxFormSubmitBehavior(form, "change") {
            });
            return textField;
        }
    };
    form.add(dateTimeField);
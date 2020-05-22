public class MyPage extends WebPage {

    private List<Double> list = Arrays.asList(2013.0, 100.500);

    public MyPage() {

        final FeedbackPanel feedback = new FeedbackPanel("feedback");
        feedback.setOutputMarkupId(true);
        add(feedback);

        ListView<Double> items = new ListView<Double>("items", new PropertyModel(this, "list")) {
            @Override
            protected void populateItem(ListItem<Double> item) {
                item.add(new AjaxEditableLabel("item", item.getModel()) {
                    @Override
                    protected void onSubmit(AjaxRequestTarget target) {
                        System.out.println(Arrays.toString(list.toArray()));
                        target.add(feedback);
                        super.onSubmit(target);
                    }

                    @Override
                    protected void onError(AjaxRequestTarget target) {
                        target.add(feedback);
                        super.onError(target);
                    }
                }.add(new IValidator<Object>() {
                    @Override
                    public void validate(IValidatable<Object> validatable) {
                        String in = String.valueOf(validatable.getValue());
                        try {
                            Double.parseDouble(in.replace(".", ","));
                        } catch (Exception ignore) {
                            try{
                                Double.parseDouble(in.replace(",", "."));
                            }catch (Exception e){
                                ValidationError error = new ValidationError(String.format("`%s` is not a Double", in));
                                validatable.error(error);
                            }
                        }
                    }
                }));
            }
        };
        add(items);
    }
}
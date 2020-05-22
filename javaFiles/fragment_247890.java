public class MyPanel extends Panel{

    private static class Mybean{

        String labelText = "click me";

        public String getLabelText(){
            return this.labelText;
        }

        public void setLabelText(final String labelText){
            this.labelText = labelText;
        }

    }

    public MyPanel(final String id){
        super(id);
        final Mybean bean = new Mybean();
        this.add(new Link<Void>("link"){

            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(){
                bean.setLabelText("Thanks for clicking");
            }
        }.add(new Label("label", new PropertyModel<String>(bean, "labelText")))

        );

    }

}
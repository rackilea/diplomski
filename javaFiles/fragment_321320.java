private Locale chosenLocale;

public LocalePage() {
    Form<Void> form = new Form<Void>( "form" ) {
        @Override
        protected void onSubmit() {
            // do something with this.chosenLocale
            // perhaps getSession().setLocale(this.chosenLocale);
        }
    };
    List<Locale> locales = new ArrayList<Locale>(Arrays.asList( Locale.ENGLISH, Locale.FRENCH  ));
    DropDownChoice<Locale> choice = new DropDownChoice<Locale>( "locale", new PropertyModel<Locale>( this,
            "chosenLocale" ), locales, new IChoiceRenderer<Locale>() {

        @Override
        public Object getDisplayValue(Locale object) {
            return object.toString();
        }

        @Override
        public String getIdValue(Locale object, int index) {
            return String.valueOf( index );
        }

    } );

    add( form.add( choice.setNullValid( false ) ) );
}
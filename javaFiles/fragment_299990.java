final IndicatingAjaxButton lookup = new IndicatingAjaxButton("lookup", form) {
  @Override
  protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
    String code = postcode.getInput();

    code = (new PostcodeValidator()).convertToObject(code,
                    getLocale());

    ... Postcode lookup here


    target.add(ContactDetailsPanel.this);
  }

  @Override
  protected void onError(AjaxRequestTarget target, Form<?> form) {
  }
};
lookup.setDefaultFormProcessing(false);
add(lookup);
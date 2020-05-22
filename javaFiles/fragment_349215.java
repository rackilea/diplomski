public class TextBoxBaseDecorater implements FocusHandler, BlurHandler, HasAttachHandlers {
  private final TextBoxBase textBoxBase;
  private final ArrayList<HandlerRegistration> handlers = new ArrayList<HandlerRegistration>();

  /*
   * Pass the TextBoxBase extending widget to be decorated.
   */
  public TextBoxBaseDecorater(TextBoxBase textBoxBase) {
    this.textBoxBase = textBoxBase;
    textBoxBase.addAttachHandler(this);
  }

  public void onBlur(BlurEvent event) {
    //cool feature implementation
  }

  public void onFocus(FocusEvent event) {
    //another cool feature
  }

  public void onAttachOrDetach(AttachEvent event) {
     if (event.isAttached() {
       handlers.add(textBoxBase.addBlurHandler(this));
       handlers.add(textBoxBase.addFocusHandler(this));
     } else {
       for (HandlerRegistration rh: handlers) {
          rh.removeHandler();
       }
       handlers.clear();
     }
  }

  //other cool features
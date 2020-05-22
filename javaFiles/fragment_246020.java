public class EspressoExtensions {
  /**
   * This can be used to close the keyboard on an input field when Android opens the keyboard and
   * selects the first input when launching a screen.
   * <p>
   * This is needed because at the moment Espresso does not wait for the keyboard to open
   */
  public static void closeKeyboardOnFocused(ViewInteraction viewInteraction) {
    viewInteraction.check(matches(hasFocus())).perform(closeSoftKeyboard());
  }
}
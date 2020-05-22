/** Interface mainly works as a marker. 
  At first look, interface isn't necessary but it'll improve maintainability.
  Next year you say 'thank you' to yourself  */
interface IController { 
  //some methods which will implement EACH controller even the most specific
  public void doGet(params)
}
abstract class AbstractController implements IController {
 /** Class implements default behavior for controllers.
     Implementation written so child classes could adopt behaviour easily*/
  @Override
  public void doGet(params) {
    // use Template pattern
    doLog(params);
    prepareStuff();
    process();
  }
  // common stuff which should be done at first
  protected void doLog(params) { // your favorite logger here}
  // extension point for inherited classes
  abstract protected void prepareStuff();
  // here is the real processing for default controller
  public void process() {
    //implement common processing for GET request
  }
  // Prefer to use protected method instead of field
  protected String getURL() { return DEFAULT_URL;}
}
// usual controller has nothing special
class Controller1 extends AbstractController {
  @Override
  protected String getURL() { return "url1";}
  @Override
  protected prepareStuff() {// do nothing}
}
// do some specific preparation/checks
class Controller2 extends AbstractController {
  @Override
  protected prepareStuff() {//preparation/checks here }
  /** Note I 'forget' to override getURL() so it'll process DEFAULT_URL.
   It could be useful if AbstractController calculates url dynamically and
   you don't want to write boilerplate strings "/myApp/section7".
   Also you could write abstract getURL()
  */
}
/** custom controller but you want to re-use some common code. 
In fact I would not recommend this way as usual approach */
class Controller3 extends AbstractController {
  /** Overriding this method totally discards the Template pattern. 
      It could (and will) lead to confusing and errors*/
  @Override
  public void doGet(params) { // new implementation }
  @Override
  protected prepareStuff() {
    // you don't need it but you have to override since it abstract
  }
}
// totally custom controller. Implements interface just as a marker
class SpecificController implements Controller {
  // In order to support legacy code just call method wich has been already written. You even no need to rename it.
  @Override
  public void doGet(params) { specificMethod();}
  // lagacy method which probably is used somewhere else
  public void specificMethod() {  // the actual logic here}
}
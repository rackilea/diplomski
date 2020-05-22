public class controller1 extends SimpleFormController implements Serializable {
private PersonManager pManager ;   
@Override
public ModelAndView onSubmit(Object command) {
    CommandPerson cmd = (CommandPerson) command;
    Person p = null;
        String viewName = "redirect:controller2.htm";
        try {
            p = pManager.getPersonbyID(cmd.getID());
        } catch (EmptyResultDataAccessException ex) {
      viewName="NosuchPerson";
        }
       ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("ID",cmd.getID());   
        return mav;
 }
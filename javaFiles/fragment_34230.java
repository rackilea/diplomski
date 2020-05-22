@Controller
public class EntryController {

   @InitBinder
   public void initBinder(WebDataBinder binder) {
      binder.registerCustomEditor(TagList.class, new TagListEditor());
   }

   // request mappings here
}
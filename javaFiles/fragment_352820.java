@Controller
@RequestMapping("/contact")  
@SessionAttributes("contact")
public class ContactController {

....
....


    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String updateContact(@PathVariable("id") Long id, Model model) {

        Contact c = contactDao.get(id);
        model.addAttribute("contact", c);
        return "contact/form";

    }


    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute Contact contact, BindingResult result, Model model) {

        contactDao.update(contact);

        return "redirect:/contact";
    }
}
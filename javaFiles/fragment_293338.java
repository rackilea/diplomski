@RequestMapping("/contact")
public String listContacts(Map<String, Object> map) {
    map.put("contact", new Contact());
    map.put("contactList", contactService.listContact());       

    return "/contact";
}
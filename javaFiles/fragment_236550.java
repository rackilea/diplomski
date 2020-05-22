@RequestMapping(value = "items/{id}", method = RequestMethod.DELETE)
public String delete(@PathVariable("id") int itemId, Model model, HttpServletReponse response) {
    Item item = itemDao.get(id);

    // true -> can delete
    // false -> cannot delete, f.e. is FK reference somewhere
    boolean wasOk = itemDao.delete(item); 

    if (!wasOk) {
        // will write to user which item couldn't be deleted
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        model.addAttribute("item", item);
        return "items/error";   
    }

    return "redirect:/items";
}
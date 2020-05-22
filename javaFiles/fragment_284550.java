@RequestMapping(value = "/panics/closeCase", method = RequestMethod.POST)
public String closeCase(@RequestParam destination, @ModelAttribute("closeCaseFrom") CloseCaseFrom closeCaseFrom, Model model) {

    //..
    if (destination.equals("a")) {
        // a goes to urlx
        return "redirect:/urlx";
    if (destination.equals("b")) { // or just else {
        // b goes to urly
        return "redirect:/urly";

}
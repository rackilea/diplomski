// the methods can have the name you want
// not only onGet, onPost, etc. as in servlets

@RequestMapping("url1.htm")
public String loadAnyJsp(@ModelAttribute Login login) {
    return "path/to/my/views/login";
}

@RequestMapping("url2.htm")
public String redirectToAnotherController(@ModelAttribute Login login) {
    return "redirect:url1.htm";
}
@RequestMapping(..)
public String foo(RedirectAttributes redir) {
  redir.addFlashAttribute("xyz", "meow");
  return "redirect:/bar";
}

@RequestMapping("/bar")
public String bar(Model model) {
  ..
}
@RequestMapping(value = "book", method = RequestMethod.POST)
public String saveOrUpdate(@ModelAttribute("book") BookCommand bookCommand,
                           @RequestParam("author") String name,
                           BindingResult bindingResult){
    if( bindingResult.hasErrors()) {
        return "redirect:/book/new";
    }

    Author author = new Author();
    author.setName(name);
    authorService.saveAuthor(author);
    savedBook.setAuthor(author);
    BookCommand savedBook = bookService.saveBookCommand(bookCommand);
    return "redirect:/book/show/"+savedBook.getId();
}
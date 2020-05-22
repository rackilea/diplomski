@PostMapping("/novo")  //can use shortened form
public String salvar(@Valid Livro livro, 
                     BindingResult result,
                     Model model, 
                     RedirectAttributes attributes) {

    if (result.hasErrors()) {
        model.addAttribute("mensagem", "Erro no formulario");
        return "Livro"; //you may want to remove the slash.  This will look for something like Livro.jsp or Livro.html.
    }

    livroService.salvar(livro);

    attributes.addFlashAttribute("mensagem", "Livro salvo com sucesso!!!");
    return "redirect:/Livros/novo"; 
}
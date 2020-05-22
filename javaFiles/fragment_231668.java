public ModelAndView create(@Valid @ModelAttribute Servicio servicio, BindingResult result, Model model) {
  throw new UnsupportedOperationException();
}

@PostMapping(name = "create")
public ModelAndView create(@Valid @ModelAttribute Servicio servicio, BindingResult result, Model model, Principal principal, Pageable pageable) {
    if (result.hasErrors()) {
        populateForm(model);

        return new ModelAndView("/servicios/create");
    }

    Prestador current = (Prestador) personaService.findByUsername(principal.getName(), pageable).getContent().get(0);

    if (current == null) { 
        populateForm(model);
        return new ModelAndView("/servicios/create");
    }
    servicio.setPrestador(current);     
    Servicio newServicio = getServicioService().save(servicio);
    return new ModelAndView("redirect:/ver-servicio/" + newServicio.getId());
}
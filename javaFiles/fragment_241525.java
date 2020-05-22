@ModelAttribute("entity")
public Entity entity(@PathVariable String id) {
    return service.getById(id);
}

@GetMapping("/{id}")
public String get() {
   return "view";
}

@PostMapping("/{id})
public String update(@ModelAttribute("entity") Entity entity) {
  service.store(entity);
  return "view";
}
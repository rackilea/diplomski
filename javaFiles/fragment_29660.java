@RequestMapping(value = "/gustos/edit")
public String updateGustoById(@RequestParam(value="gustos") int id, @RequestParam(value="newCat") 
int newIdCat, @RequestParam(value="newName") String newName)
{
  Gusto gusto = gustoService.findGustoById(id);
  gusto.setNombre(newName);
  gusto.setIdCategoria(newIdCat);
  gustoService.update(gusto);
  return "redirect:/gustos/edit";
}
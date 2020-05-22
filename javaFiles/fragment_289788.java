@PreAuthorize("#userId == principal.getId()")
@GetMapping
@ResponseBody
public Resource fineOne(@PathVariable Long userId) {
    return resourceService.findOne(id);
}
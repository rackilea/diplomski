@PreAuthorize("userIdentity(#userId)")
@GetMapping
@ResponseBody
public Resource fineOne(@PathVariable Long userId) {
    return resourceService.findOne(id);
}
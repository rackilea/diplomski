@GetMapping
@ResponseBody
public Resource fineOne(@PathVariable Long userId) {
    SecurityUtils.checkUserIdentity(userId)
    return resourceService.findOne(id);
}
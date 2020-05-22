@PreAuthorize("hasRole('your-scope-role')")
@RequestMapping(value = "/hello")
@ResponseBody
public String hello(Principal principal) {
    return "Hello to " + principal.getName();
}
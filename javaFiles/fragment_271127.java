@PostMapping(value = "/path")
public String serve(final Model model)
{
if (everything_fine)
{
    return "path_to_page_which_will_be_handled_by_view_controller";
}
return "path_to_EMPTY_page_which_will_be_handled_by_view_controller";
}
@RequestMapping(value="/create", method=RequestMethod.POST)
public void create(..., @ModelAttribute("myAttribute") MyClass myAttribute,
                    @RequestParam("myTags") String myTags, ...) {
    ...
    myAttribute.setListOfTags(Arrays.asList(myTags.split(",")));
    ...
}
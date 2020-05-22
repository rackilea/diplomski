@RequestMapping(value='/articles/{id}/processTest')
public String someMethod(Model model, @PathVariable Long id, 
                         @RequestParam(value = "q[]") List<String> qList,
                         @RequestParam(value = "a[]") List<String> aList){
    ...
}
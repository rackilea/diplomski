@RequestMapping(value = "/section/add",
                method = RequestMethod.POST
                params="createGroupSection=false")
@ResponseBody
public boolean addSection(@ModelAttribute("section") Section section) {...}

@RequestMapping(value = "/section/add",
                method = RequestMethod.POST
                params="createGroupSection=true")
@ResponseBody
public boolean addGroupSection(@ModelAttribute("section") Section section) {...}
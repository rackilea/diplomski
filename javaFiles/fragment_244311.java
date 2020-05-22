@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=save")
public ModelAndView save() {}


@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=cancel")
public ModelAndView cancel() {}
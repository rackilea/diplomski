@RequestMapping(value = "/employees1", method = RequestMethod.GET)
public ModelAndView employeelist() {
    Gson gson = new Gson();
    String json = gson.toJson(employeeService.listEmployeess());

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject(json);

    return modelAndView;
}
@RequestMapping(value = "/{id}", method = RequestMethod.POST)
public @ResponseBody  ModelAndView onSubmit(
        @RequestBody ServersListModel serversListModel,
        @PathVariable("id") Long responsibleId,
        BindingResult result,
        SessionStatus status) throws ParseException, IOException {

    if (!result.hasErrors()) {
        if (serversListModel.getAssignedServers() != null) {
            for (Long id : serversListModel.getAssignedServers()) {
                ServerEntity entity = employeeService.getServerById(id);
                entity.setResponsible(responsibleId);
                adminService.updateServer(entity);
            }
        }

        if (serversListModel.getAvailableServers() != null) {
            for (Long id : serversListModel.getAvailableServers()) {
                ServerEntity entity2 = employeeService.getServerById(id);
                entity2.setResponsible((long) 0);
                adminService.updateServer(entity2);
            }
        }
        status.setComplete();
        return new ModelAndView("redirect:/employee_management/employee_manager");
    } else {
        return new ModelAndView("redirect:/employee_management/serv_assignment");
    }
}
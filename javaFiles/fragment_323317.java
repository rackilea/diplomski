@RequestMapping(value = "/delete/{id}" method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public void doPostDelete(@RequestBody Employee employee, @PathVariable("id") String id ) {
        int idInt = Integer.parseInt(id);
        employee.setEmpId(idInt - 1);
        employeeService.deleteEmployee(employee);
    }
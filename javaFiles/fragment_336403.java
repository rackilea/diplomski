// POST: Save product
        @RequestMapping(value = { "/add-employee" }, method = RequestMethod.POST, consumes = {"multipart/form-data"})
        public String productSave(@ModelAttribute("employee") Employee employee,  @RequestPart("file") MultipartFile file)

        {      
            employeeService.saveEmployee(employee);

            return "redirect:/add-employee";
        }
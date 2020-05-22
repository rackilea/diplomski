@RequestMapping("list/excell")
public View listExcell() {
    return new AbstractExcelView() {
        @Override
        protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
                HttpServletRequest request, HttpServletResponse response) throws Exception {
            HSSFSheet sheet = workbook.createSheet("List of employees");

            setText(getCell(sheet, 0, 0), "Id");
            setText(getCell(sheet, 0, 1), "First name");
            setText(getCell(sheet, 0, 2), "Last name");
            setText(getCell(sheet, 0, 3), "Active");
            setText(getCell(sheet, 0, 4), "Salary");

            List<Employee> employees = dao.listEmployees();
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                setText(getCell(sheet, i + 1, 0), String.valueOf(employee.getId()));
                setText(getCell(sheet, i + 1, 1), employee.getFirstName());
                setText(getCell(sheet, i + 1, 2), employee.getLastName());
                setText(getCell(sheet, i + 1, 3), String.valueOf(employee.isActive()));
                setText(getCell(sheet, i + 1, 4), String.valueOf(employee.getSalary()));
            }
        }
    };
}
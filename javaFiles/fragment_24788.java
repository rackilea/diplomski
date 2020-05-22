@RequestMapping(value = "/delete_all", method = RequestMethod.POST)
@ResponseBody
public boolean deleteMultipleRecord(@RequestParam(value = "empList[]", required = false) String[] empListToBeRemoved, HttpServletRequest request) {
    Employee emp = new Employee();
    for (int i = 0; i <= empListToBeRemoved.length-1; i++) {
        boolean result = false;
        if (!empListToBeRemoved[i].equals("0")) {
            emp.setEmpIdEnc(empListToBeRemoved[i]);
            try {
                List<OrgStructureTagging> list = orgStructureTaggingDAO.findEmpByProperty("EMP_ID", emp.getEmpId());
                for (OrgStructureTagging structureTagging : list) {
                    System.out.println("all ids of employees" + structureTagging.getEmployee().getName());
                    orgStructureTaggingDAO.delete(structureTagging);
                }
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Error Occured While updating the field");
                result = false;
            }
        }
    }
    return result;
}
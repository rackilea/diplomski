void process(final Map<Integer, Integer> map1,
        final Map<Integer, String> map, final Map<Integer, EmployeeVO> empDetails) {

    final Iterator<Integer> keys = map1.keySet().iterator();
    while (keys.hasNext()) {
        EmployeeVO empVO = new EmployeeVO();
        Integer empId = keys.next();
        empVOsetEmpId(empId);
        empVO.setEmpAmount(map1.get(empId));

        if (("Y".equals(map.get(empId))))
            empVO setInd("Y");
        else
            empVO setInd("N");
        empDetails.put(empId, empVO);
    }
}
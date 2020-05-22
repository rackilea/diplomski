Integer id = (Integer) filters.get("id");
if (id != null && !id.equals(employee.getId())) return false;

BigDecimal salary = (BigDecimal) filters.get("salary");
if (salary != null && ((salary.compareTo(employee.getSalary()) < 0)) return false;

return true;
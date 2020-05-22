ParameterExpression<Date> inputDateExp = criteriaBuilder.parameter(Date.class, "inputDate");
Predicate employeeCreationDate = criteriaBuilder.lessThanOrEqualTo(
        employee.<Date>get("creationDate"), inputDateExp);
Predicate contractStartDate = criteriaBuilder.lessThanOrEqualTo(
        employee.join("contract").<Date>get("fromDate"), inputDateExp);

criteria.add(
        criteriaBuilder.selectCase().when(employee.get("contract").isNull(), employeeCreationDate).otherwise(contractStartDate));
return reactiveMongoTemplate.findById(empID).map(employee -> {
            if (!showExtraDetails) {
              employee.getDetails().setExtraDetails(null);
            }
            return employee;                
        });
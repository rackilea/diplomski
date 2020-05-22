Constraint constraint = new Constraint();
constraint.setCutOffTime("2019-12-19T20:59:59.059");
constraint.setCurrentTime("2019-12-19T16:51:08.970");
constraint.setDeliveryPossible(false);

Result<Constraint> result = new Result<>(constraint);
JsonResponse returnObject = new JsonResponse();
returnObject.setSuccess(true);
returnObject.setResult(result);

ObjectMapper mapper = new ObjectMapper();
System.out.println(mapper.writeValueAsString(returnObject));
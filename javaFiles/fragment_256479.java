List<AggregationOperation> stages = new ArrayList<>();

stages.add(unwind("$subWarrantyCategories"));

List<Criteria> andList = new ArrayList<>();

Criteria c1 = new Criteria("subWarrantyCategories.filtersAllowed.type._id").is("CODE_ACTE");
Criteria c2  new Criteria("subWarrantyCategories.filtersAllowed.valuesAutorized.id").is("ORT");
Criteria c3 =  new Criteria("subWarrantyCategories.filtersAllowed.valuesAutorized.operator").is("=");
Criteria c4  new Criteria("subWarrantyCategories.filtersAllowed.type._id").is("TYP_ACCORD");
Criteria c5 =  new Criteria("subWarrantyCategories.filtersAllowed.valuesAutorized.id").is("0");
Criteria c5 =  new Criteria("subWarrantyCategories.filtersAllowed.valuesAutorized.operator").is("=");


andList.add(new Criteria().andOperator(c1, new Criteria().andOperator(c2,c3)));
andList.add(new Criteria().andOperator(c4, new Criteria().andOperator(c5,c6)));

stages.add(match(new Criteria().andOperator(andList.toArray(new Criteria[andList.size()]))));

ProjectionOperation projection = project("_id", "label",  "code").and("$subWarrantyCategories.label").as("labelSCat").and("$subWarrantyCategories._id").as("CodeSCat");

stages.add(projection);

newAggregation(stages)
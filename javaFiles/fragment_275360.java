Requirement requirementToUpdate = em.find(Requirement.class, pk);//replace pk with your PrimaryKey value
Requirement newRequirement = new Requirement();//fill in the properties

newRequirement.getRequirementList1().add(requirementToUpdate);//this is very important for your code
requirementToUpdate.getRequirementList().add(newRequirement);//this is very important for persistence
em.persist(newRequirement);//this should not insert anything in the 'requirement_has_requirement' table
em.persist(requirementToUpdate);//this should update the 'requirement_has_requirement' table
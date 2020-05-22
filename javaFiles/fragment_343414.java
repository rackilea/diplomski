//Create the proces variables
     Map<String, Object> variables = new HashMap<String, Object>();
         variables.put("requester", userRequestingForAbsence); //User who wants timeOff
         variables.put("dateFrom", new Date(2015, 10, 10));
         variables.put("dateTo", new Date(2015, 11, 11));
         variables.put("group", groupDto);
         variables.put("organization", orgDto.getOrganizationId());
         variables.put("candidateApprover", p.getUserId());

         //Create the process instance
//Im using org.activiti.engine.RuntimeService
         ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess", String.valueOf(orgDto.getOrganizationId()),variables);
         //Create Process Instance
         Assert.assertNotNull(pi);

         //Check inbox for approver 
         Task task = taskService.createTaskQuery()
                 ))
                   // .taskCandidateGroup(String.valueOf(orgDto.getOrganizationId()))
                    .taskAssignee(String.valueOf(p.getUserId()))
                    .singleResult();

         Assert.assertEquals("RequestAproval", task.getName());


         //Approver Completes ApprovalRequest and we add additional values THIS IS THE PART YOU ARE INTERESTED IN I THINK

         Map<String, Object> userTaskVariables = new HashMap<String, Object>();
         userTaskVariables.put("requestAccepted", true);
         userTaskVariables.put("approver",approver);

         //Complete Task
         taskService.complete(task.getId(),userTaskVariables);
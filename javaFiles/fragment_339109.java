String queueNames = String.format("projects/%s/locations/%s/queues/%s", _projectName,_location, queueName);

              // Create the PullTasksRequest
              LeaseTasksRequest request = new LeaseTasksRequest().setMaxTasks(tasksBulkSize).setLeaseDuration(String.valueOf(leaseTimeInSecs)+"s").setResponseView("FULL");

              //Execute the request and return the pulled task
              LeaseTasksResponse response = _cloudTasksClient
                  .projects()
                  .locations()
                  .queues()
                  .tasks()
                  .lease(queueNames, request)
                  .execute();
              return response.getTasks();
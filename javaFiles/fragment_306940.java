SQLAdmin.Instances.SQLAdminImport request = sqlAdminService.instances().sqladminImport(CLOUD_PROJECT, CLOUD_SQL_INSTANCE, requestBody);
        // execution of our import request
        Operation response = request.execute();
        int tried = 0;
        Operation statusOperation;
        do {
            // sleep one minute
            Thread.sleep(60000);
            // here we are requesting the status of our operation. Name is actually the unique identifier
            Get requestStatus = sqlAdminService.operations().get(CLOUD_PROJECT, response.getName());
            statusOperation = requestStatus.execute();
            tried++;
            System.out.println("status is: " + statusOperation.getStatus());
        } while(!statusOperation.getStatus().equalsIgnoreCase("DONE") && tried < 10);
        if (!statusOperation.getStatus().equalsIgnoreCase("DONE")) {
            throw new Exception("import failed: Timeout");
        }
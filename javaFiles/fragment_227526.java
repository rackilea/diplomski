ObjectNode allProcesses = Json.newObject();

    allProcesses.put("Prozess1", "Hallo ich bin ein Prozess");


    return ok(allProcesses);
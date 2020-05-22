IloIntRange nodes = opl.getElement("nodes").asIntRange();
    IloIntRange vehicles = opl.getElement("vehicles").asIntRange();
    IloIntVarMap serviceTime = opl.getElement("service_time").asIntVarMap();

    final int nbNodes = nodes.getSize();
    final int nbVehicles = vehicles.getSize();

    IloNumVar[] startX = new IloNumVar[nbNodes * nbVehicles];
    double[] startVals = new double[nbNodes * nbVehicles];
    for (int i = 0; i < nbNodes; i++) {
       IloIntVarMap inner = serviceTime.getSub(nodes.getValue(i));
       for (int j = 0; j < nbVehicles; j++) {
          int idx = i * nbVehicles + j;
          startX[idx] = inner.get(vehicles.getValue(j));
          startVals[idx] = 1.0;
       }
    }

    cplex.addMIPStart(startX, startVals);
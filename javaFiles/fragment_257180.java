AdminCommand cmd = cmdMgr.createCommand("createCluster");

            //gotoStep
    CommandStep step = ((TaskCommand) cmd).gotoStep("clusterConfig");

    step.setParameter("clusterName", ClusterName);
    step.setParameter("preferLocal", true);

    cmd.setConfigSession(session);
    cmd.execute();
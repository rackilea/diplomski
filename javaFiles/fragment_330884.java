List < String > paramsExecute = new ArrayList < String > ();
paramsExecute.add("java");
paramsExecute.add("-cp");
paramsExecute.add(Path); 
paramsExecute.add("-Djava.security.manager");
paramsExecute.add("-Djava.security.policy=C:\\full\\path\\MyPolicyFile.policy");
paramsExecute.add("dummy."+packageName);
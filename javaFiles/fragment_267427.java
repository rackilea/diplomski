StringBuilder rawScript = new StringBuilder();

Map<String, String> resolvedFunctions = ScriptBuilder.resolveFunctionDependenciesForStatements(
    new HashMap<String, String>(), ImmutableSet.of(bootstrap), OsFamily.UNIX);

ScriptBuilder.writeFunctions(resolvedFunctions, OsFamily.UNIX, rawScript);
rawScript.append(bootstrap.render(OsFamily.UNIX));

ssh.put("/tmp/chef-bootstrap.sh", rawScript.toString());
ExecResponse result = ssh.exec("bash /tmp/chef-bootstrap.sh");
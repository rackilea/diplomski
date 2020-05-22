instructions.install = \
  addJvmArg(jvmArg:-javaagent:${artifact.location}/agent/my-agent.jar);
instructions.install.import = \
  org.eclipse.equinox.p2.touchpoint.eclipse.addJvmArg, \
  org.eclipse.equinox.p2.touchpoint.eclipse.removeJvmArg
instructions.uninstall = \
  removeJvmArg(jvmArg:-javaagent:${artifact.location}/agent/my-agent.jar);
instructions.uninstall.import = \
  org.eclipse.equinox.p2.touchpoint.eclipse.addJvmArg, \
  org.eclipse.equinox.p2.touchpoint.eclipse.removeJvmArg
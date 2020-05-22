// Terminate.
RConnection c2 = new RConnection();
// SIGTERM might not be understood everywhere: so using SIGKILL signal, as well.
c2.eval("tools::pskill("+ this.rServePid + ")");
c2.eval("tools::pskill("+ this.rServePid + ", tools::SIGKILL)");
c2.close();
LOG.info("Rserve: terminated instance with pid '" + this.rServePid + "'.");
@ManagedOperation
public synchronized ConfigurableApplicationContext restart() {
  if (this.context != null) {
    if (this.integrationShutdown != null) {
      this.integrationShutdown.stop(this.timeout);
    }
    this.application.setEnvironment(this.context.getEnvironment());
    this.context.close();
    overrideClassLoaderForRestart();
    this.context = this.application.run(this.args);
  }
  return this.context;
}
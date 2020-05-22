public Result createSession(HttpClient client, Command command)
    throws IOException {
    // Avoid serialising the capabilities too many times. Things like profiles are expensive.

    Capabilities desired = (Capabilities) command.getParameters().get("desiredCapabilities");
    desired = desired == null ? new DesiredCapabilities() : desired;
    Capabilities required = (Capabilities) command.getParameters().get("requiredCapabilities");
    required = required == null ? new DesiredCapabilities() : required;

    String des = new BeanToJsonConverter().convert(desired);
    String req = new BeanToJsonConverter().convert(required);

    // Assume the remote end obeys the robustness principle.
    StringBuilder parameters = new StringBuilder("{");
    amendW3CParameters(parameters, des, req);
    parameters.append(",");
    amendOssParamters(parameters, des, req);
    parameters.append("}");
    LOG.info("Attempting bi-dialect session, assuming Postel's Law holds true on the remote end");
    Optional result = createSession(client, parameters);

    // Assume a fragile OSS webdriver implementation
    if (!result.isPresent()) {
      parameters = new StringBuilder("{");
      amendOssParamters(parameters, des, req);
      parameters.append("}");
      LOG.info("Falling back to original OSS JSON Wire Protocol.");
      result = createSession(client, parameters);
    }

    // Assume a fragile w3c implementation
    if (!result.isPresent()) {
      parameters = new StringBuilder("{");
      amendW3CParameters(parameters, des, req);
      parameters.append("}");
      LOG.info("Falling back to straight W3C remote end connection");
      result = createSession(client, parameters);
    }

    if (result.isPresent()) {
      Result toReturn = result.get();
      LOG.info(String.format("Detected dialect: %s", toReturn.dialect));
      return toReturn;
    }

    throw new SessionNotCreatedException(
      String.format(
        "Unable to create new remote session. " +
        "desired capabilities = %s, required capabilities = %s",
        desired,
        required));
}
WebAppContext context = new WebAppContext();
context.setContextPath("/");

switch (getOperationalMode())
{
    case PROD:
        // Configure as WAR
        context.setWar(basePath.toString());
        break;
    case DEV:
        // Configuring from Development Base
        context.setBaseResource(new PathResource(basePath.resolve("src/main/webapp")));
        // Add webapp compiled classes & resources (copied into place from src/main/resources)
        Path classesPath = basePath.resolve("target/thewebapp/WEB-INF/classes");
        context.setExtraClasspath(classesPath.toAbsolutePath().toString());
        break;
    default:
        throw new FileNotFoundException("Unable to configure WebAppContext base resource undefined");
}
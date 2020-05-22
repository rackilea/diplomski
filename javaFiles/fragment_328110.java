@Parameters
public class ImportParameters {

  @Parameter(names = { "-f", "--file" }, required = true, description = "Data file")
  private File file;

  @Parameter(names = { "-t", "--type" }, required = true, description = "Data type")
  private DataType dataType;

  @Parameter(names = { "-o", "--overwrite" }, description = "Flag to overwrite file if it exists")
  private Boolean overwrite = false;

  /* getters and setters */
}

public class ImportCommandExecutor {

  public void run(ImportParameters params) throws Exception {
    // import logic goes here
  }

}

/* Handles interactive shell command execution */
@ShellComponent
public class JLineInputExecutor {

  // All command executors are injected here
  @Autowired private ImportCommandExecutor importExecutor;
  ...

  @ShellMethod(key = "import", value = "Imports the a file of a specified type.")
  public String importCommand(@ShellOption(optOut = true) ImportParameters params) throws Exception {
    importCommandExecutor.run(params);
  }

  ...

}

/* Handles one-off command execution */
public class JCommanderInputExecutor implements ApplicationRunner {

  // All command executors are injected here
  @Autowired private ImportCommandExecutor importExecutor;
  ...

  @Override
  public void run(ApplicationArguments args) throws Exception {

    // Create all of the JCommander argument handler objects
    BaseParameters baseParameters = new BaseParameters();
    ImportParameters importParameters = new ImportParameters();
    ...

    JCommander jc = newBuilder().
      .acceptUnknownOptions(true)
      .addObject(baseParameters)
      .addCommand("import", importParameters)
      ...
      .build();

    jc.parse(args);
    String mainCommand = jc.getParsedCommand();

    if ("import".equals(mainCommand)){
      importExecutor.run(importParameters);
    } else if (...) {
      ...
    }  

  }
}

@Configuration
@Profile({"CLI"})
public class CommandLineInterfaceConfiguration {

  // All of my command executors are defined as beans here, as well as other required configurations for both modes of execution 
  @Bean
  public ImportCommandExecutor importExecutor (){
    return new ImportCommandExecutor();
  }
  ...

}

@Configuration
@Profile({"SINGLE_COMMAND"})
public class SingleCommandConfiguration {

  @Bean
  public JCommanderInputExecutor commandLineInputExecutor(){
    return new JCommanderInputExecutor();
  }

}

@SpringBootApplication
public class Application {

  public static void main(String[] args) throws IOException {
    String[] profiles = getActiveProfiles(args);
    SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
    builder.bannerMode((Mode.LOG));
    builder.web(false);
    builder.profiles(profiles);
    System.out.println(String.format("Command line arguments: %s  Profiles: %s",
        Arrays.asList(args), Arrays.asList(profiles)));
    builder.run(args);
  }

  private static String[] getActiveProfiles(String[] args){
    return Arrays.asList(args).contains("-X") ? new String[]{"CLI", "SINGLE_COMMAND"} : new String[]{"CLI"};
  }

}
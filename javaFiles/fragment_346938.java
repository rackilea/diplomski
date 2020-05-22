public class YAMLSample {

  final String fileName = "/tmp/rest.yml";

  public void writeToYML() throws IOException {
    log( "Write to YML" );

    Map<String, Object> user = new HashMap<>();
    user.put( "name", "user5" );
    user.put( "type", "allow" );
    user.put( "auth_key", "user5:user5" );
    user.put( "kibana_access", "ro" );
    user.put( "indices", new String[] { ".kibana*", "abc", "def" } );

    Map<String, Object> user2 = new HashMap<>();
    user2.put("name", "user2");
    user2.put("type", "allow");
    user2.put("auth_key", "user2:user2");
    user2.put("kibana_access", "ro");
    user2.put("indices", new String[] { ".kibana*", "abc", "def" });

    List<Map<String, Object>> list = new ArrayList<>();
    list.add(user);
    list.add(user2);

    Map<String, List<Map<String, Object>>> config = new HashMap<>();
    config.put( "access_control_rules", list );

    DumperOptions options = new DumperOptions();
    options.setIndent( 6 );
    options.setIndicatorIndent( 4 );
    options.setDefaultFlowStyle(DumperOptions.FlowStyle.AUTO);

    Yaml yaml = new Yaml(options);
    FileWriter writer = new FileWriter(fileName, true);

    yaml.dump( config, writer );
    log( "DONE!" );
  }

  public static void main(String[] args) throws IOException {
    new YAMLSample().writeToYML();
  }

  public void log(String str) {
    System.out.println(str);
  }
}
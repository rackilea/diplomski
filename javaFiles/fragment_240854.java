final Yaml yaml = new Yaml();
final Iterator<Event> events = yaml.parse(new StreamReader(new UnicodeReader(
        new FileInputStream(new File("test.yml"))).iterator();

final DumperOptions yamlOptions = new DumperOptions();
final Emitter emitter = new Emitter(new PrintWriter(System.out), yamlOptions);
while (events.hasNext()) emitter.emit(events.next());
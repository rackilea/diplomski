public class Main {
  public static void main(String[] args) {
      Tap sourceTap = new FileTap(new TextDelimited(true, ","), "inputFile.txt");
      Tap sink_one = new FileTap(new TextDelimited(true, ","), "maleFile.txt");
      Tap sink_two = new FileTap(new TextDelimited(true, ","), "FemaleFile.txt");

      Pipe assembly = new Pipe("inputPipe");

      Pipe malePipe = new Pipe("for_male", assembly);
      malePipe=new Each(malePipe,new CustomFilterByGender("male"));
      Pipe femalePipe = new Pipe("for_female", assembly);
      femalePipe=new Each(femalePipe, new CustomFilterByGender("female"));

      List<Pipe> pipes = new ArrayList<Pipe>(2);
      pipes.add(malePipe);
      pipes.add(femalePipe);

      Map<String, Tap> sinks = new HashMap<String, Tap>();
      sinks.put("for_male", sink_one);
      sinks.put("for_female", sink_two);

      FlowConnector flowConnector = new LocalFlowConnector();
      Flow flow = flowConnector.connect(sourceTap, sinks, pipes);
      flow.complete();
  }
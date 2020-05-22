FileReader fr = new FileReader(file);
BufferedReader br = new BufferedReader(fr);

String[] lineBuffer;
int bufferCount = 0;
int N = 1000;

String line = br.readLine();

while(line!=null) {
    if(0 == bufferCount)
      lineBuffer = new String[N];
    else if(N == bufferCount) {
      Props props = Props.create(LogLineProcessor.class);
      ActorRef lineProcessorActor = this.getContext().actorOf(props);

      lineProcessorActor.tell(new LogLineMessage(lineBuffer),
                              this.getSelf());

      bufferCount = 0;
      continue;
    }

    lineBuffer[bufferCount] = line;
    br.readLine();
    bufferCount++;
}

//handle the final buffer
if(bufferCount > 0) {
    Props props = Props.create(LogLineProcessor.class); 
    ActorRef lineProcessorActor = this.getContext().actorOf(props);

    lineProcessorActor.tell(new LogLineMessage(lineBuffer),
                            this.getSelf());
}
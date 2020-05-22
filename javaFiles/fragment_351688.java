interface StageProcessor {
    OutputType process(Stage stage);
}

@Component
@Processes(StageType.A)
class StageProcessorA implements StageProcessor{
      OutputType process(Stage stage){
        //validate stage is StageType.A
      }
}

@interface Processes{
    StageType type;
    StageType getType(){
        return type;
    }
}

@Component
@Processes(StageType.B)
class StageProcessorB implements StageProcessor{

}

@Service
class StageProcessors {
    Map<StageType, List<StageProcessor>> stageProcessors;

    StageProcessors(Collection<StageProcessor> processors) {
        Map<StageType, List<StageProcessor>> map = new HashMap<>();
        for (StageProcessor processor : processors) {
            StageType stageType = processor.getClass().getAnnotation(Processes.class).getType();
            map.computeIfAbsent(stageType, k -> new ArrayList<>()).add(processor);
        }
        stageProcessors = map;
        assert stageProcessors.size() == expectedNumberOfProcessors;
    }

    List<StageProcessor> getProcessors(StageType stage) {
        return stageProcessors.get(stage);
    }
}
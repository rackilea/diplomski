private final ThreadLocal<EmitterProcessor<Object>> emitterProcessorHolder = ThreadLocal.withInitial(() -> {
  EmitterProcessor<Object> processor = ...
  return processor;
});
...
@Override
public void onMessage(Object message){
  emitterProcessorHolder.get().onNext(message); 
}
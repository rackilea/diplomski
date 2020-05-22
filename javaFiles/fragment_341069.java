final Class<?> queueHolderClass = 
    Class.forName("com.google.inject.internal.util.$MapMaker$QueueHolder");
final Field queueField = queueHolderClass.getDeclaredField("queue");
// make MapMaker.QueueHolder.queue accessible
queueField.setAccessible(true);
// remove the final modifier from MapMaker.QueueHolder.queue
final Field modifiersField = Field.class.getDeclaredField("modifiers");
modifiersField.setAccessible(true);
modifiersField.setInt(queueField, queueField.getModifiers() & ~Modifier.FINAL);
// set it to null
queueField.set(null, null);
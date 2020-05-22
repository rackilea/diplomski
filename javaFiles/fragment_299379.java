List<Class<? extends ExerciseMovement>> exerciseClasses = ExerciseMovementRegister.getClasses();

for(Class klass: exerciseClasses) {
  ExerciseMovement move = (ExerciseMovement) klass.newInstance();
  move.start();
}
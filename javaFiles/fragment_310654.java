public abstract class Trainer
  <A extends Animal<?,?>, // <- here you are not enforcing the right bounds
   E extends Enum<E> & TrainingActions<A>,
   T extends Temperament,
   S extends Show>{
  …
}
public interface AnimalTrainer<T extends Animal>
 {
    public void trainAnimal(T animal);
 }

public class LionTrainer implements AnimalTrainer<Lion>
 {
    public void trainAnimal(Lion lion);
 }
public interface Life {
  //methods that implementation of this interface should implement
}

public abstract LifeForm extends Model implements Life {
  int hitPoints;
  //other LifeForm specific methods and instance variables
}

public Hero extends LifeForm {
  //Hero specific methods like save the damsel
}
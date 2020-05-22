@GroupSequence(value={Car.class, Contraint1Group.class,Contraint2Group.class})
public class Car {

  @ContraintA(groups=Contraint1Group.class)
  @ContraintB(groups=Contraint2Group.class)
  private String type;

}
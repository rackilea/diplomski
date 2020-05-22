@Component
public class InjuryToDTOConverter{

  public InjuryDTO convert(Injury source){
    InjuryDTO target = new InjuryDTO();
    BeanUtils.copyProperties(source, target); //it will copy fields with the same names
    target.setAthleteId(source.getAthlete().getId());
    return target;
  }
}
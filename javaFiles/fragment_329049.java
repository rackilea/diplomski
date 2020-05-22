public interface EntityService {

  @Transactional
  EntityA getA(Long id);

  @Transactional
  EntityB getB(Long id);
}

public class WebPageController {

  public void handleGet(Long id1, Long id2) {
    EntityA a = entityService.getA(id1);
    try {
      EntityB b = entityService.getB(id2);
    } catch (Exception e) {
      //print somthething
    }
    a.accessLazyField(); //will throw lazy load after getB throws exception
  }
}
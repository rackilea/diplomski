@RestControllerAdvice(assignableTypes = {CarController.class})
public class InterceptModelPathParameterControllerAdvice {

  @Autowired
  CarService carService;

  @ModelAttribute
  public void validateModel(@PathVariable("model") String model) {
    if (!carService.isSupportedModel(model)) throw new RuntimeException("This model is not supprted by this application.");
  }
}
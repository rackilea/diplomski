@Controller
class HomeController {
  val log: Logger = LoggerFactory.getLogger(this.getClass.getName)

  @RequestMapping(Array("/"))
  def home: String = {
    log.debug("HomeController::home")

    "home/home"
  }
}
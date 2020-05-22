@Controller
@RequestMapping( what ever you have in common )
class Handler {

  @RequestMapping(params={"type=1"})
  public void mode1() {
     ...
  }

  @RequestMapping(params={"type=2"})
  public void mode2() {
     ...
  }
}
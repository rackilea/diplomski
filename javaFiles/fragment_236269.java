@Singleton
class Application @Inject() (userAuthAction: UserAuthAction) extends Controller {
  def index = (userAuthAction andThen anyAction) { request =>
    Ok(views.html.index())
  }
}
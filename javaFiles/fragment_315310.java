object AssetsController extends Controller {

def modifiedAsset(path: String, file: String): Future[Result] = Async.action { implicit request =>
  Assets.at(path, file)(request).map { result => 
   result.withHeaders(("X-Robots-Tag", "noindex"))
  }
}
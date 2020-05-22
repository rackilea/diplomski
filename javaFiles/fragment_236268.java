@Singleton
class UserAuthAction @Inject() (principalService: PrincipalService) extends ActionBuilder[Request] with ActionFilter[Request] {
  override protected def filter[A](request: Request[A]) = Future.successful {
    request.session.get(principalService.accessTokenCacheKey).map { accessToken =>
      if (principalService.authenticate(accessToken))
        None
      else
        Some(Results.Redirect(routes.PrincipalController.login()))
    } getOrElse {
      Some(Results.Redirect(routes.PrincipalController.login()))
    }
  }
}
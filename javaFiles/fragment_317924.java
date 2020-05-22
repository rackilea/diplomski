Observable<Boolean> checkResponseType( ResponseException response ) {
  if ( response.getCode() == 404 ) {
    return Observable.error( response );
  }
  return Observable.just( Boolean.TRUE );
}
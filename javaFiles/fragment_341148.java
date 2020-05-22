play.api.mvc.Result wrappedResult = result.getWrappedResult();
  if (wrappedResult instanceof play.api.mvc.PlainResult) {
    play.api.mvc.PlainResult plainResult = (play.api.mvc.PlainResult)wrappedResult;
    int code = plainResult.header().status();
    if (code == OK)
      // Cache
  }
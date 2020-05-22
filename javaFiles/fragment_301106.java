package com.acme.controllers.handlers;

import play.*;
import play.api.OptionalSourceMapper;
import play.api.UsefulException;
import play.api.routing.Router;
import play.http.DefaultHttpErrorHandler;
import play.libs.F.*;
import play.mvc.Http.*;
import play.mvc.*;

import javax.inject.*;

public class ErrorHandler extends DefaultHttpErrorHandler {

    @Inject
    public ErrorHandler(Configuration configuration, Environment environment,
                        OptionalSourceMapper sourceMapper, Provider<Router> routes) {
        super(configuration, environment, sourceMapper, routes);
    }

    @Override
    protected Promise<Result> onNotFound(RequestHeader request, java.lang.String message) {
      Logger.error("onHandlerNotFound!");
      return Promise.pure(Results.internalServerError(views.html.page404.render()));
    }
}
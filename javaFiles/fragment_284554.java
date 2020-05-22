class ErrorsController {

    def handle = {
        def exception = request.exception.cause.class
        if(exception == my.project.NoSessionException ||
               exception == my.project.AccessDeniedException)
            render(view: '/accessDenied')
        else
            render(view: '/errorProduction')
    }

}
// Check registered HandlerExceptionResolvers...
ModelAndView exMv = null;

for (HandlerExceptionResolver handlerExceptionResolver : this.handlerExceptionResolvers) {
    exMv = handlerExceptionResolver.resolveException(request, response, handler, ex);
    if (exMv != null) {
        break;
    }
}
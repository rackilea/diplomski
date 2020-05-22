@Override
public int filterOrder() {
    return 10;
}

@Override
public boolean shouldFilter() {
    RequestContext ctx = RequestContext.getCurrentContext();

    if ((ctx.get("proxy") != null) && ctx.get("proxy").equals("foo")) {
        return true;
    }
    return false;
}
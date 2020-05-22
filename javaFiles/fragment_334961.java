Context context = (Context) wrapper.getParent();
    Host currentHost = (Host) context.getParent();
    Engine engine = (Engine) currentHost.getParent();

    StandardHost host = new StandardHost();
    host.setAppBase(appBase);
    host.setName(domainName);

    engine.addChild(host);
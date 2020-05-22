JMeterContext jmctx = JMeterContextService.getContext();
    JMeterVariables vars = jmctx.getVariables();

    try {
        bshInterpreter.set("ctx", jmctx);//$NON-NLS-1$
        bshInterpreter.set("Label", getName()); //$NON-NLS-1$
        bshInterpreter.set("prev", jmctx.getPreviousResult());//$NON-NLS-1$
        bshInterpreter.set("props", JMeterUtils.getJMeterProperties());
        bshInterpreter.set("vars", vars);//$NON-NLS-1$
protected void startup() {
    inputFields  =GenUtil.uncheckedCast(context.get("Input Fields"  ,null));
    outputFields =GenUtil.uncheckedCast(context.get("Output Fields" ,null));
    eventRegistry=GenUtil.uncheckedCast(context.get("Event Registry",null));
    ...
    }
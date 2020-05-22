....
ScriptInjector.fromString(
   "$wnd.addthis_config = $wnd.addthis_config||{};" +
   "$wnd.addthis_config.pubid = '+ " AT_PUBID + "';"
).inject();
ScriptInjector.fromUrl(AT_URL).inject();
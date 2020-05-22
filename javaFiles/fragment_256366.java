CompilerConfiguration compilerConfiguration = new CompilerConfiguration();
String path = SCRIPT_PLACED_AT;
if(!SCRIPT_PLACED_AT.endsWith("/")){
                        path = path+ "/";
                    }
compilerConfiguration.setClasspath(path);
GroovyShell groovyShell = new GroovyShell(
                            compilerConfiguration);
for (String scriptName : files) {
                        Script script = groovyShell.parse(new File(
                                SCRIPT_PLACED_AT + Constants.SLASH
                                        + SCRIPT_FILE_FOLDER + Constants.SLASH
                                        + scriptName));
                        scriptMping.put(scriptName, script);
                    }
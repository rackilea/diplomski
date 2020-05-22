io.undertow.Undertow server = io.undertow.Undertow.builder()
                    .addHttpListener(curPort, "localhost")
                    .setHandler(path)
                    .setServerOption(io.undertow.UndertowOptions.MAX_PARAMETERS, 10000)
                    .setServerOption(io.undertow.UndertowOptions.OPTION2, Value2)
                    .build();
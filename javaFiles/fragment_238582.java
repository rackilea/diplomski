final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_17,
                PROXY_HOST, PROXY_PORT);

WebRequest request = new WebRequest(new URL(
                "http://steamcommunity.com/id/bobcatchris/inventory#730"));

webClient.getOptions().setThrowExceptionOnScriptError(false);
webClient.setJavaScriptTimeout(10000);
webClient.getOptions().setJavaScriptEnabled(true);
webClient.setAjaxController(new NicelyResynchronizingAjaxController());
webClient.getOptions().setTimeout(10000);

HtmlPage page = webClient.getPage(request);

          String script="var list = [];\n" +
                    "\n" +
                    "\n" +
                    "var size = Object.keys(g_ActiveInventory.rgInventory).size();\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "var counter = 0;\n" +
                    "\n" +
                    "while (counter < size) {\n" +
                    " list.push(g_ActiveInventory.rgInventory[Object.keys(g_ActiveInventory.rgInventory)[counter]].market_name);\n" +
                    " counter +=1;\n" +
                    "}";
            Object result = page.executeJavaScript(script).getJavaScriptResult();
            System.out.println(result);
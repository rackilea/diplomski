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
                    "}"
                    + "list";

            Object result = page.executeJavaScript(script).getJavaScriptResult();
            if (result instanceof NativeArray) {
                for (Object obj : (NativeArray)result) {
                    System.out.println(obj);    
                }

            }
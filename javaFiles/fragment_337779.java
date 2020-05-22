String script = "window.addEventListener('load', function() {" +
                "  alert('ok'); " +
                "})";

JavascriptExecutor js =(JavascriptExecutor)driver;
js.executeScript(script);
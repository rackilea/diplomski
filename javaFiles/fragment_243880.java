public class MyWebViewClient extends WebViewClient {
    @Override
    public void onPageFinished(WebView view, String url) {
        view.loadUrl("javascript: "
                + "Object.prototype.each = function (fn, bind) {\n" +
                "                console.log(bind);\n" +
                "                for (var i = 0; i < this.length; i++) {\n" +
                "                    if (i in this) {\n" +
                "                        fn.call(bind, this[i], i, this);\n" +
                "                    }\n" +
                "                }\n" +
                "            };\n" +
                "\n" +
                "            var _addListener = document.addEventListener || document.attachEvent,\n" +
                "                _eventClick = window.addEventListener ? 'click' : 'onclick';\n" +
                "\n" +
                "            var elements = document.getElementsByTagName(\"div\");\n" +
                "\n" +
                "            elements.each(function (el) {\n" +
                "                _addListener.call(el, _eventClick, function () {\n" +
                                 // todo process the clicked div element
                "                    el.style.cssText = \"border-color:  black;border-style:  dashed;\"\n" +
                "                }, false);\n" +
                "            })");
    }
}
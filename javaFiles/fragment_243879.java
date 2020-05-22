class MyWebViewClient : WebViewClient() {
        override fun onPageFinished(view: WebView, url: String) {
            view.loadUrl("javascript: " +
                    """
            Object.prototype.each = function (fn, bind) {
                console.log(bind);
                for (var i = 0; i < this.length; i++) {
                    if (i in this) {
                        fn.call(bind, this[i], i, this);
                    }
                }
            };

            var _addListener = document.addEventListener || document.attachEvent,
                _eventClick = window.addEventListener ? 'click' : 'onclick';

            var elements = document.getElementsByTagName("div");

            elements.each(function (el) {
                _addListener.call(el, _eventClick, function () {
                    // todo process the clicked div element
                    el.style.cssText = "border-color:  black;border-style:  dashed;"
                }, false);
            })
                    """.trimIndent())
        }
    }
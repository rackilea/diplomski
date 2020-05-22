webview.evaluateJavascript("(function() { "javascript:(function(){"+
                "aTagElements=document.getElementsByTagName('a');" +
                "randromElement=aTagElements[Math.floor(Math.random() * aTagElements.length)];"+
                "clickEvent=document.createEvent('HTMLEvents');"+
                "clickEvent.initEvent('click',true,true);"+
                "randromElement.dispatchEvent(clickEvent);" +
                "alert('event dispatched.');";
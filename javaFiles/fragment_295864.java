// request is the incoming HTTP request
if (request.getParameter("receiveInput") != null){
        HTML.clickHtmlLink(objBrowser, ".text", "receiveInput",1);
    }
    else if (request.getParameter("receiveSyncIt...") != null) {
        HTML.clickHtmlLink(objBrowser, ".text", "receiveSyncIt...",1);
    }
    else if (request.getParameter("ReceiveQueryI...") != null) {
        HTML.clickHtmlLink(objBrowser, ".text", "ReceiveQueryI...",1);
    }
    else {
        HTML.clickHtmlLink(objBrowser, ".text", "ReceiveWF_EVE...",1);
    }
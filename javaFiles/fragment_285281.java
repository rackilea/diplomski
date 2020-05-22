simpleCart({
    checkout: {
        type: "SendForm" ,
        url: "http://example.com/your/custom/checkout/url" ,
        method: "GET" ,
        success: "success.html" ,
        cancel: "cancel.html" ,
        extra_data: {
            customInfo1: "some custom information",
            customInfo2: "12321321"
        }
    }
});
<script language="JavaScript" type="text/javascript">
    $(document).ready(function () {
        // Your data
        var arr = {
                    id: '51f631cb84812abb04000006',
                    checkoutID: {
                        id: '123456789',
                        "shippingAddress" : "5h avenue - new york",
                        "billingAddress" : "5h avenue - new york"
                    }
                  };
        $.ajax({
            url: '/json/cart.do',
            type: 'POST',
            data: JSON.stringify(arr),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            async: false,
            success: function (msg) {
                alert(msg.result);
            }
        });
    });
</script>
function getBusinessBill(billReference, billInvoiceDate) {

    $.post("/AccountStatement/businessBill.htm", {
        reference: billReference,
        invoiceDate: billInvoiceDate
    }, function (data) {

        /* You can implement more validations for 'data', in my case I just used these 'if' conditionals but can vary. */

        if(data != null) { //returned 'data' is not 'null'

            /* parse 'data' as 'json' object
             * will be good to console.log(data) and take a look. */
            var obj = $.parseJSON(data);

            if(obj != {}) { //check if 'data' is not an empty 'json' object once transformed

               //set the 'data' in the dialog
               $('#dlg-account-number').text(obj.accountNumber);
               $('#dlg-bill-date').text(obj.billDate);

               /* open modal dialog, you can simulate it this way (for this case)
                * but the correct way is to use 'jquery-ui' dialog or any plugin you prefer.
                * At this point you will see the hidden 'div' in a visible way with your 'data'.
                */
               $('#BusinessBill').fadeIn();
            } else {
               //show 'generic' message
               alert('No results found.');
            }
        } else {
           //show 'generic' message
           alert('An error occurred, try again.');
        }
    });

}
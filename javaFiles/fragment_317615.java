// Set up PayPal with the checkout.js library
paypal.Button.render({
  env: 'production', // or 'sandbox'

  payment: function () {
    return paypalCheckoutInstance.createPayment({
      flow: 'vault',
      billingAgreementDescription: 'Your agreement description',
      enableShippingAddress: true,
      shippingAddressEditable: false,
      shippingAddressOverride: {
        recipientName: 'Scruff McGruff',
        line1: '1234 Main St.',
        line2: 'Unit 1',
        city: 'Chicago',
        countryCode: 'US',
        postalCode: '60652',
        state: 'IL',
        phone: '123.456.7890'
      }
    });
  },

  onAuthorize: function (data, actions) {
    return paypalCheckoutInstance.tokenizePayment(data)
      .then(function (payload) {
        // Submit `payload.nonce` to your server.
      });
  }
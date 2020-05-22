{
  "data": [
    com.stripe.model.Customer JSON: {
      "object": "customer",
      "created": 1410001523,
      "id": "cus_4j9JlwfZ5arO4M",
      "livemode": false,
      "description": null,
      "email": "customer@example.com",
      "delinquent": false,
      "metadata": {
      },
      "subscriptions": {
        "object": "list",
        "total_count": 0,
        "has_more": false,
        "url": "/v1/customers/cus_4j9JlwfZ5arO4M/subscriptions",
        "data": [

        ]
      },
      "discount": null,
      "account_balance": 0,
      "currency": "usd",
      "cards": {
        "object": "list",
        "total_count": 1,
        "has_more": false,
        "url": "/v1/customers/cus_4j9JlwfZ5arO4M/cards",
        "data": [
          {
            "id": "card_14Zh0M2eZvKYlo2CAl9gQ262",
            "object": "card",
            "last4": "4242",
            "brand": "Visa",
            "funding": "credit",
            "exp_month": 12,
            "exp_year": 2015,
            "fingerprint": "Xt5EWLLDS7FJjR1c",
            "country": "US",
            "name": "akinci_yasin@hotmail.com",
            "address_line1": null,
            "address_line2": null,
            "address_city": null,
            "address_state": null,
            "address_zip": null,
            "address_country": null,
            "cvc_check": null,
            "address_line1_check": null,
            "address_zip_check": null,
            "customer": "cus_4j9JlwfZ5arO4M"
          }
        ]
      },
      "default_card": "card_14Zh0M2eZvKYlo2CAl9gQ262"
    },
    #<com.stripe.model.Customer[...] ...>,
    #<com.stripe.model.Customer[...] ...>
  ],
  "has_more": false
}
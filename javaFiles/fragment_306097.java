static mapping = {
        id composite: ["serviceProviderId", "sportsId"]
        version false
        serviceProvider column: '`service_provider_id`', insertable: false, updateable: false
        sports column: '`sports_id`', insertable: false, updateable: false
    }
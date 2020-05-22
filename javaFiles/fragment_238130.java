collection.update(
    { "country": "New Zealand", "regions.region": " "Waikato" },
    { "$inc": regions.$.size": 145 },
    true,
    false
)
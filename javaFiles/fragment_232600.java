{
    offset: 0,
    max_num: 1000,
    fields: ["id", "custom_uuid_c"],
    filter: [{"custom_uuid_c": {"$not_empty": ""}}],
    ]
}
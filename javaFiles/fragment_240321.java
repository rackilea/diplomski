{
    "params": {
        "props": [
            {
                "_user_id": "177032492760",
                "_user_name": "John"
            },
            {
                "_user_id": "177032492760",
                "_user_name": "Mike"
            },
            {
                "_user_id": "100007496328",
                "_user_name": "Wilber"
            }
        ]
    },
    "query": "FOREACH (p in {props} | MERGE (user:People {id:{p._user_id}}) ON CREATE  user.name = {p._user_name}) "
}
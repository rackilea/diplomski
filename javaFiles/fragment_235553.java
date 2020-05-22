>>> user_dict = json.loads('{
    "firstName" : "Zen", "lastName" : "coder", 
    "address" : ["High st, Point place", "Wisconcin", "4E23C"]
    }')
>>> user = User(**user_dict)
>>> user.address
    <user_address.Address at 0x10ced2d10>
>>> user.address.city
    u'Wisconcin'
>>> user_dict = json.loads('{
    "firstName" : "Zen", "lastName" : "coder", 
    "address" : "bad address"
    }')
    TypeError: address must be provided as an Address object, list, or dictionary
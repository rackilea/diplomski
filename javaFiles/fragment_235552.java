>>> import json
>>> user_dict = json.loads('{
    "firstName" : "Zen", "lastName" : "Coder", 
    "address" : {
        "addressFirstLine" : "High st, Point place",
        "city" : "Wisconcin", 
        "pincode" : "4E23C"}
    }')
>>> from user_address import User
>>> user = User(**user_dict)
>>> user
    <user_address.User at 0x1035b4190>
>>> user.firstName
    u'Zen'
>>> user.lastName
     u'coder'
>>> user.address
     <user_address.Address at 0x1035b4710>
>>> user.address.addressFirstLine
    u'High st, Point place'
>>> user.address.city
    u'Wisconcin'
>>> user.address.pincode
    u'4E23C'
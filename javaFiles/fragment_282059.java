const UserSchema = new Schema({
email: {type: String, required: true},
password: {type: String, required: true},
address: [{
    street: {type: String, required: true},
    city: {type: String, required: true},
    state: {type: String, required: true},
    zip: {type: String, required: true}
}]

})
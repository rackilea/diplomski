String json = "[";

for (Player player : participants) {
    json += "{";
    json += "\"Id\":\"" + (player.email.length() > 0 ? player.email : player.phoneNumber) + "\",";
    json += "\"FirstName\":\"" + player.firstName + "\",";
    json += "\"LastName\":\"" + player.lastName + "\",";
    json += "\"PhoneNumber\":\"" + player.phoneNumber + "\"";
    json += "},";
}

json = json.substring(0, json.length()-1) + "]";
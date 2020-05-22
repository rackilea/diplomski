String json = "{";

for(int i = 0; i < YOUR_ARRAY.length; i += 2;) {
    json += "\"" + YOUR_ARRAY[i] + "\":\"" + YOUR_ARRAY[i + 1] + "\"";

    //Some kind of if condition to decide if a comma is required (Last entry)
}

json += "}";
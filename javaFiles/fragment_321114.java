class Baselike {
    String type;
    String payloadStr;
}

class Payload
{
    public int foo; // whatever the format is
    public String bar;
}

Gson g = new Gson();
Baselike baseObj = gson.fromJson(response, Baselike.class);
Payload payloadObj = gson.fromJson(baseObj.payloadStr, Payload.class);
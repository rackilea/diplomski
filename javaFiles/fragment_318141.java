{
    req, res -> {
        val obj = JsonObject().addProperty("foo", "bar")
        Gson().toJson(obj).toString()
    }
}
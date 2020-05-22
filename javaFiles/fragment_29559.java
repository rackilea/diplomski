Express app  = new Express();

app.get("/", (req, res) -> {
    res.send("Hello World");
});

app.listen();
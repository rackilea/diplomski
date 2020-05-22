{
    use("*", (req, rsp, chain) -> {
        String value = req.route().attr("authenticationTokenValidator");
        // your code goes here
    });
}
.addRule(
    Join.path("/{i}/{d}")
        .to("/resources/html/user/doSomething.html")
        .where("i").matches("[-_a-zA-Z0-9~*]{8}")
        .where("d").matches("[-_a-zA-Z0-9~*]{32}")
        .withRequestBinding();
)
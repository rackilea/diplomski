final Div name = new Div(new Text("Product"));
final Div interestRate = new Div(new Text(String.format("Ставка: %.2f",
            0.05d)));
final Div duration = new Div(new Text(String.format("Срок: %d - %d "
            + "месяцев", 10, 11)));
final Div provider = new Div(new Text(String.format("Организация: %s"
            , 10)));
final Div description = new Div(new Text("<html>Hi there! <b>Bold</b>"
            + " text</html>"));
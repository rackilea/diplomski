class Controller {
    Parser parser;

    Model getModel() {
        return parser.parseModel(userInput);
    }

    Template getTemplate() {
        return parser.parseTemplate(userInput);
    }
}
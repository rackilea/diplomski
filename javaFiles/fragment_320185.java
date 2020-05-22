onException(Exception.class)
            .handled(true)
            .log("Globally Caught CustomException")
            .end();
onException(JAXBException.class)
            .handled(true)
            .throwException(new CustomException())
            .end();
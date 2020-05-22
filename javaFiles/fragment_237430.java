AddNumbersImplService service = new AddNumbersImplService();
AddNumbersImpl port = service.getAddNumbersImplPort();

((BindingProvider)port).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS,
    Collections.singletonMap("X-Client-Version",Collections.singletonList("1.0-RC")));

port.addNumbers(3, 5);
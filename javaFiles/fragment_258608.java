while (responder.isNotFinished()) {
    line = s.nextLine();

    response = responder.getResponse(line);
    System.out.println(response);
}
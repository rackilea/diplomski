if (annotationAction.get(PdfName.S).equals(PdfName.URI)) {
    final PdfString destination = annotationAction.getAsString(PdfName.URI);
    final String url = destination.toString();
    System.out.println(url);
    String updatedUrl = [... url changed to match the changed criteria ...];
    annotationAction.put(PdfName.URI, new PdfString(updatedUrl));
}
context.getFetchConfiguration().getDocumentFetchConfiguration()
  .setFetchAudio("/audio/fetch.wav");

Message message = new Message("wait-message", 
  new SpeechSynthesis("Please wait a moment."));

DialogueUtils.doTurn(message, context);
performLongOperation();
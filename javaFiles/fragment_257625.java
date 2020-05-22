DtmfRecognition dummyRecognition = new DtmfRecognition(new GrammarReference("builtin:dtmf/digits"));

SpeechSynthesis message = new SpeechSynthesis("Please wait a moment.");

Interaction interaction = OutputTurns.interaction("wait-message")
                .addPrompt(dummyRecognition, message).build();

DialogueUtils.doTurn(interaction, context);
performLongOperation();
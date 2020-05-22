private void forcePlayMessage(VoiceXmlDialogueContext context,
                              String messageName,
                              AudioItem... audioItems)
                throws Timeout, InterruptedException {
    DtmfRecognition dummyRecognition = new DtmfRecognition(new GrammarReference("builtin:dtmf/digits"));
    Interaction interaction = OutputTurns.interaction(messageName)
            .addPrompt(dummyRecognition, audioItems).build();
    DialogueUtils.doTurn(interaction, context);
}
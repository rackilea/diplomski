RecognizeOptions options = new RecognizeOptions();
options = options.continuous(true)
          .contentType(HttpMediaType.AUDIO_WAV)
          .interimResults(false)
          .inactivityTimeout(10)
          .maxAlternatives(1)
          .wordConfidence(false)
          .timestamps(true)
          .model("en-US_BroadbandModel");
SpeechResults transcript = service.recognize(audio, options);
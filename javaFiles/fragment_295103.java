Instrument instruments[];
Soundbank sb=synthesizer.getDefaultSoundbank();
if (sb!=null) instruments=synthesizer.getDefaultSoundbank().getInstruments();

...

      try
      {
        Sequence sequence=MidiSystem.getSequence(file);                                  // From file

        int trackNumber=0;
        for (Track track : sequence.getTracks())
        {
          System.out.print("Track "+(trackNumber++)+" : ");
          MidiEvent event=track.get(0);
          MidiMessage message=event.getMessage();
          if (message instanceof ShortMessage)
          {
            ShortMessage sm=(ShortMessage)message;
            if (sm.getCommand()==192) Out("sm.getChannel()="+sm.getChannel()+"  sm.getData1()="+sm.getData1()+"  "+instruments[sm.getData1()]);
          }
        }
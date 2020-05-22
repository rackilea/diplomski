try
        {
             ShortMessage instrumentChange = new ShortMessage();

             instrumentChange.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 6,0);

             //MidiEvent instrumentChange = new MidiEvent(ShortMessage.PROGRAM_CHANGE,drumPatch.getBank(),drumPatch.getProgram());
             track.add(new MidiEvent(instrumentChange,0));
        }
        catch(Exception e)
        {
            //Handle
        }
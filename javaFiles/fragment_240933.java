int i = 0;

            while(itr.hasNext())
            {
                MIDIMessage msg = (MIDIMessage)itr.next();

                ShortMessage noteOnMsg = new ShortMessage();
                //Signal/Channel/Pitch/Velocity
                noteOnMsg.setMessage(ShortMessage.NOTE_ON, 0,msg.GetPitch(),msg.GetVelocity());

                ShortMessage noteOffMsg = new ShortMessage();
                //Signal/Channel/Pitch/Velocity
                noteOffMsg.setMessage(ShortMessage.NOTE_OFF,0,msg.GetPitch(),msg.GetVelocity());

                track.add(new MidiEvent(noteOnMsg,i));
                i = i+50;
                track.add(new MidiEvent(noteOffMsg,i));
                i = i+50;
            }
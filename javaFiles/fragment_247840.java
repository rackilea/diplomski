StringInstrument[] stringInstruments = new StringInstrument [10];
for (int i = 0; i < stringInstruments.length; i++){//begin for loop
        stringInstruments[i] = new StringInstrument(); 
        stringInstruments[i].SetInstrumentName(instrumentList[i]); //You want to initialize the name of the instrument here. 
        output.println(stringInstruments[i].InstrumentNameDisplay());
        output.println(stringInstruments[i].NumberOfStrings(stringNumber[i]));
        output.println(stringInstruments[i].TuneInstrument());
        output.println(stringInstruments[i].PlayInstrument());    
        output.println(stringInstruments[i].PlayInstrumentBand());
        output.println(stringInstruments[i].StopPlayInstrument());
   }//end for loop
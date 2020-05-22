/**                                                                                                                                                
 * Get Wav Amplitudes                                                                                                                              
 *                                                                                                                                                 
 * @param file                                                                                                                                     
 * @return                                                                                                                                         
 * @throws UnsupportedAudioFileException                                                                                                           
 * @throws IOException                                                                                                                             
 */                                                                                                                                                
private int[] getWavAmplitudes(File file) throws UnsupportedAudioFileException , IOException {                                                     

    //Get Audio input stream                                                                                                                       
    try (AudioInputStream input = AudioSystem.getAudioInputStream(file)) {                                                                         
        AudioFormat baseFormat = input.getFormat();                                                                                                

        //Encoding                                                                                                                                 
        Encoding encoding = AudioFormat.Encoding.PCM_UNSIGNED;                                                                                     
        float sampleRate = baseFormat.getSampleRate();                                                                                             
        int numChannels = baseFormat.getChannels();                                                                                                

        AudioFormat decodedFormat = new AudioFormat(encoding, sampleRate, 16, numChannels, numChannels * 2, sampleRate, false);                    
        int available = input.available();                                                                                                         

        //Get the PCM Decoded Audio Input Stream                                                                                                   
        try (AudioInputStream pcmDecodedInput = AudioSystem.getAudioInputStream(decodedFormat, input)) {                                           
            final int BUFFER_SIZE = 4096; //this is actually bytes                                                                                 

            //Create a buffer                                                                                                                      
            byte[] buffer = new byte[BUFFER_SIZE];                                                                                                 

            //Now get the average to a smaller array                                                                                               
            int maximumArrayLength = 100000;                                                                                                       
            int[] finalAmplitudes = new int[maximumArrayLength];                                                                                   
            int samplesPerPixel = available / maximumArrayLength;                                                                                  

            //Variables to calculate finalAmplitudes array                                                                                         
            int currentSampleCounter = 0;                                                                                                          
            int arrayCellPosition = 0;                                                                                                             
            float currentCellValue = 0.0f;                                                                                                         

            //Variables for the loop                                                                                                               
            int arrayCellValue = 0;                                                                                                                

            //Read all the available data on chunks                                                                                                
            while (pcmDecodedInput.readNBytes(buffer, 0, BUFFER_SIZE) > 0)                                                                         
                for (int i = 0; i < buffer.length - 1; i += 2) {                                                                                   

                    //Calculate the value                                                                                                          
                    arrayCellValue = (int) ( ( ( ( ( buffer[i + 1] << 8 ) | buffer[i] & 0xff ) << 16 ) / 32767 ) * WAVEFORM_HEIGHT_COEFFICIENT );  

                    //Every time you him [currentSampleCounter=samplesPerPixel]                                                                    
                    if (currentSampleCounter != samplesPerPixel) {                                                                                 
                        ++currentSampleCounter;                                                                                                    
                        currentCellValue += Math.abs(arrayCellValue);                                                                              
                    } else {                                                                                                                       
                        //Avoid ArrayIndexOutOfBoundsException                                                                                     
                        if (arrayCellPosition != maximumArrayLength)                                                                               
                            finalAmplitudes[arrayCellPosition] = finalAmplitudes[arrayCellPosition + 1] = (int) currentCellValue / samplesPerPixel;

                        //Fix the variables                                                                                                        
                        currentSampleCounter = 0;                                                                                                  
                        currentCellValue = 0;                                                                                                      
                        arrayCellPosition += 2;                                                                                                    
                    }                                                                                                                              
                }                                                                                                                                  

            return finalAmplitudes;                                                                                                                
        } catch (Exception ex) {                                                                                                                   
            ex.printStackTrace();                                                                                                                  
        }                                                                                                                                          
    } catch (Exception ex) {                                                                                                                       
        ex.printStackTrace();                                                                                                                      

    }                                                                                                                                              

    //You don't want this to reach here...                                                                                                         
    return new int[1];                                                                                                                             
}
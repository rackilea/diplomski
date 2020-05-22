// loads the InputStream for the sound 
InputStream inputStream = this.getClass().getResourceAsStream( musicFile ); 

// create the standard Player 
musicPlayer = Manager.createPlayer( inputStream, musicEncoding ); 
musicPlayer.prefetch(); 

// add player listener to access sound events 
musicPlayer.addPlayerListener( this ); 

if( loopMusic ) 
{     
    // use the loop count method for infinite looping 
    musicPlayer.setLoopCount( -1 ); 
} 

// The set occurs twice to prevent sound spikes at the very  
// beginning of the sound. 
VolumeControl volumeControl =  
   (VolumeControl) musicPlayer.getControl( "VolumeControl" ); 
volumeControl.setLevel( curVolume ); 

// finally start the piece of music 
musicPlayer.start(); 

// set the volume once more 
volumeControl = (VolumeControl) musicPlayer.getControl( "VolumeControl" ); 
volumeControl.setLevel( curVolume ); 

// finally, delete the input stream to save on resources 
inputStream.close(); 
inputStream = null;
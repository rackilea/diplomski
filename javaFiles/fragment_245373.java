class Mp3FileXuggler {

private boolean DEBUG = true;

private String _sInputFileName;
private IContainer _inputContainer;
private int _iBitRate;
private IPacket _packet;
private int _iAudioStreamId;
private IStreamCoder _audioCoder;

private int _iSampleBufferSize;
private int _iInputSampleRate;

private static SourceDataLine mLine;

private int DECODED_AUDIO_SECOND_SIZE = 176375; /** bytes */
private int _bytesPerPacket;

private byte[] _residualBuffer;

/**
 * Constructor, prepares stream to be readed
 * @param input input File
 * @throws UnsuportedSampleRateException 
 */
public Mp3FileXuggler(String sFileName) throws UnsuportedSampleRateException{
    this._sInputFileName = sFileName;
    this._inputContainer = IContainer.make();
    this._iSampleBufferSize = 18432;
    this._residualBuffer = null;

    /** Open container **/
    if (this._inputContainer.open(this._sInputFileName, IContainer.Type.READ, null) < 0)
        throw new IllegalArgumentException("Could not read the file: " + this._sInputFileName);

    /** How many streams does the file actually have */
    int iNumStreams = this._inputContainer.getNumStreams();
    this._iBitRate = this._inputContainer.getBitRate();

    if (DEBUG) System.out.println("Bitrate: " + this._iBitRate);

    /** Iterate the streams to find the first audio stream */
    this._iAudioStreamId = -1;
    this._audioCoder = null;
    boolean bFound = false;
    int i = 0;
    while (i < iNumStreams && bFound == false){

        /** Find the stream object */
        IStream stream = this._inputContainer.getStream(i);
        IStreamCoder coder = stream.getStreamCoder();

        /** If the stream is audio, stop looking */
        if (coder.getCodecType() == ICodec.Type.CODEC_TYPE_AUDIO){
            this._iAudioStreamId = i;
            this._audioCoder = coder;
            this._iInputSampleRate = coder.getSampleRate();
            bFound = true;
        }
        ++i;
    }

    /** If none was found */
    if (this._iAudioStreamId == -1)
        throw new RuntimeException("Could not find audio stream in container: " + this._sInputFileName);

    /** Otherwise, open audiocoder */

    if (this._audioCoder.open(null,null) < 0)
        throw new RuntimeException("could not open audio decoder for container: " + this._sInputFileName);

    this._packet = IPacket.make();

    //openJavaSound(this._audioCoder);

    /** Dummy read one packet to avoid problems in some audio files */
    this._inputContainer.readNextPacket(this._packet);


    /** Supported sample rates */
    switch(this._iInputSampleRate){
        case 22050:
                this._bytesPerPacket = 2304;
            break;

        case 44100:
                this._bytesPerPacket = 4608;
            break;


    }

}

public byte[] getSamples(){
    byte[] rawBytes = null;


        /** Go to the correct packet */
        while (this._inputContainer.readNextPacket(this._packet) >= 0){
            //System.out.println(this._packet.getDuration());
            /** Once we have a packet, let's see if it belongs to the audio stream */

            if (this._packet.getStreamIndex() == this._iAudioStreamId){
                IAudioSamples samples = IAudioSamples.make(this._iSampleBufferSize, this._audioCoder.getChannels());


                //  System.out.println(">> " + samples.toString());
                /** Because a packet can contain multiple set of samples (frames of samples). We may need to call
                 * decode audio multiple times at different offsets in the packet's data */

                int iCurrentOffset = 0;
                while(iCurrentOffset < this._packet.getSize()){

                    int iBytesDecoded = this._audioCoder.decodeAudio(samples, this._packet, iCurrentOffset);
                    iCurrentOffset += iBytesDecoded;

                    if (samples.isComplete()){
                        rawBytes = samples.getData().getByteArray(0, samples.getSize());

                        //playJavaSound(samples);
                    }
                }
                return rawBytes;
            }
            else{
                /** Otherwise drop it */
                do{}while(false);
            }
        }

    return rawBytes; /** This will return null at this point */
}
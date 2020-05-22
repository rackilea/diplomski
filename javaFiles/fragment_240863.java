public String record() {

                // please note: the emulator only supports 8 khz sampling.
                // so in test mode, you need to change this to
                //int frequency = 8000;

                int frequency = 11025;

                int channelConfiguration = AudioFormat.CHANNEL_CONFIGURATION_MONO;
                int audioEncoding = AudioFormat.ENCODING_PCM_16BIT;
                File file = new File(Environment.getExternalStorageDirectory()
                                .getAbsolutePath() + "/reverseme.pcm");

                // Delete any previous recording.
                if (file.exists())
                        file.delete();

                // Create the new file.
                try {
                        file.createNewFile();
                } catch (IOException e) {
                        throw new IllegalStateException("Failed to create "
                                        + file.toString());
                }

                try {
                        // Create a DataOuputStream to write the audio data into the saved
                        // file.
                        OutputStream os = new FileOutputStream(file);
                        BufferedOutputStream bos = new BufferedOutputStream(os);
                        DataOutputStream dos = new DataOutputStream(bos);

                        // Create a new AudioRecord object to record the audio.
                        int bufferSize = 2 * AudioRecord.getMinBufferSize(frequency,
                                        channelConfiguration, audioEncoding);
                        AudioRecord audioRecord = new AudioRecord(
                                        MediaRecorder.AudioSource.MIC, frequency,
                                        channelConfiguration, audioEncoding, bufferSize);

                        short[] buffer = new short[bufferSize];
                        audioRecord.startRecording();

                        Log.e(tag, "Recording started");

                        long start = SystemClock.elapsedRealtime();
                        long end = start + 15000;
                        while (SystemClock.elapsedRealtime() < end) {
                                int bufferReadResult = audioRecord.read(buffer, 0, bufferSize);
                                for (int i = 0; i < bufferReadResult; i++)

                                        if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
                                                dos.writeShort( EndianUtils.swapShort(buffer[i]));                                                
                                        } else {
                                                dos.writeShort( buffer[i] );                                                                
                                        }
                        }

                        Log.e(tag, "Recording stopped");

                        audioRecord.stop();
                        bos.flush();
                        dos.close();
                        isRecording = false;
                        return file.getAbsolutePath();

                } catch (Exception e) {
                        Log.e(tag, "Recording Failed:" + e.getMessage());
                        throw new RuntimeException("Failed to create " + e.getMessage());

                }
        }
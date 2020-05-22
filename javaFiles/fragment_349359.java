android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_AUDIO);

AudioRecord record = new AudioRecord(MediaRecorder.AudioSource.MIC,
            sampleRate,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize);
record.startRecording();
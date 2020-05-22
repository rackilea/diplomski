while (true) {
    // read data from file and feed it to the decoder input buffers.
    int inputBufferIndex = codec.dequeueInputBuffer(100);
    if (!done_reading && inputBufferIndex >= 0) {
        sample_size = extractor.readSampleData(inputBuffers[inputBufferIndex], 0);
        if (firstSampleData
                && format.getString(MediaFormat.KEY_MIME).equals("audio/mp4a-latm")
                && sample_size == 2) {
            extractor.advance();
            tot_size_read += sample_size;
        } else if (sample_size < 0) {
            // All samples have been read.
            codec.queueInputBuffer(
                    inputBufferIndex, 0, 0, -1, MediaCodec.BUFFER_FLAG_END_OF_STREAM);
            done_reading = true;
        } else {
            presentation_time = extractor.getSampleTime();
            codec.queueInputBuffer(inputBufferIndex, 0, sample_size, presentation_time, 0);
            extractor.advance();
            tot_size_read += sample_size;
            if (mProgressListener != null) {
                if (!mProgressListener.reportProgress((float) (tot_size_read) / mFileSize)) {
                    // We are asked to stop reading the file. Returning immediately. The
                    // SoundFile object is invalid and should NOT be used afterward!
                    extractor.release();
                    extractor = null;
                    codec.stop();
                    codec.release();
                    codec = null;
                    return;
                }
            }
        }
        firstSampleData = false;
    }
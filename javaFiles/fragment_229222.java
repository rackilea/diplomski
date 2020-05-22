private void mergeFiles() {
    try {   
        DataSource videoDataSource = javax.media.Manager.createDataSource(oml.getURL()); //your video file
        DataSource audioDataSource = javax.media.Manager.createDataSource(realAudioFile.toURI().toURL()); // your audio file
        DataSource mixedDataSource = null; // data source to combine video with audio
        DataSource arrayDataSource[] = new DataSource[2]; //data source array
        DataSource outputDataSource = null; // file to output

        DataSink outputDataSink = null; // datasink for output file

        MediaLocator videoLocator = new MediaLocator(oml.getURL()); //media locator for video 
        MediaLocator audioLocator = new MediaLocator(realAudioFile.toURI().toURL()); //media locator for audio

        FileTypeDescriptor outputType = new FileTypeDescriptor(FileTypeDescriptor.QUICKTIME); //output video format type

        Format outputFormat[] = new Format[2]; //format array 
        VideoFormat videoFormat = new VideoFormat(VideoFormat.JPEG); // output video codec MPEG does not work on windows
        javax.media.format.AudioFormat audioMediaFormat = new javax.media.format.AudioFormat(
                javax.media.format.AudioFormat.LINEAR, 44100, 16, 1); //audio format


        outputFormat[0] = videoFormat;
        outputFormat[1] = audioMediaFormat;

        //create processors for each file
        Processor videoProcessor = Manager.createProcessor(videoDataSource); 
        Processor audioProcessor = Manager.createProcessor(audioDataSource);
        Processor processor = null;

        //start video and audio processors
        videoProcessor.realize();
        audioProcessor.realize();
        //wait till they are realized
        while(videoProcessor.getState() != 300 && audioProcessor.getState() != 300) {
            Thread.sleep(100);
        }
        //get processors dataoutputs to merge
        arrayDataSource[0] = videoProcessor.getDataOutput();
        arrayDataSource[1] = audioProcessor.getDataOutput();

        videoProcessor.start();
        audioProcessor.start();

        //create merging data source
        mixedDataSource = javax.media.Manager.createMergingDataSource(arrayDataSource);
        mixedDataSource.connect();
        mixedDataSource.start();
        //init final processor to create merged file
        ProcessorModel processorModel = new ProcessorModel(mixedDataSource, outputFormat, outputType);
        processor = Manager.createRealizedProcessor(processorModel);
        processor.addControllerListener(this);
        processor.configure();
        //wait till configured
        while(processor.getState() < 180) {
            Thread.sleep(20);
        }

        processor.setContentDescriptor(new ContentDescriptor(FileTypeDescriptor.QUICKTIME));

        TrackControl tcs[] = processor.getTrackControls();
        Format f[] = tcs[0].getSupportedFormats();

        tcs[0].setFormat(f[0]);

        processor.realize();
        //wait till realized
        while(processor.getState() < 300) {
            Thread.sleep(20);
        }
        //create merged file and start writing media to it
        outputDataSource = processor.getDataOutput();
        MediaLocator outputLocator = new MediaLocator("file:/"+directory.getAbsolutePath()+"/yourmovfile.mov");
        outputDataSink = Manager.createDataSink(outputDataSource, outputLocator);
        outputDataSink.open();
        outputDataSink.addDataSinkListener(this);
        outputDataSink.start();
        processor.start();

        while(processor.getState() < 500) {
            Thread.sleep(100);
        }
        //wait until writing is done
        waitForFileDone();
        //dispose processor and datasink
        outputDataSink.stop();
        processor.stop();

        outputDataSink.close();
        processor.close();

    } catch (NoDataSourceException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IncompatibleSourceException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (NoDataSinkException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (NoProcessorException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (CannotRealizeException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

Object waitFileSync = new Object();
boolean fileDone = false;
boolean fileSuccess = true;
Object waitSync = new Object();
boolean stateTransitionOK = true;

/**
 * Block until file writing is done.
 */
boolean waitForFileDone() {
    synchronized (waitFileSync) {
        try {
            while (!fileDone)
                waitFileSync.wait();
        } catch (Exception e) {
        }
    }
    return fileSuccess;
}

/**
 * Event handler for the file writer.
 */
public void dataSinkUpdate(DataSinkEvent evt) {

    if (evt instanceof EndOfStreamEvent) {
        synchronized (waitFileSync) {
            fileDone = true;
            waitFileSync.notifyAll();
        }
    } else if (evt instanceof DataSinkErrorEvent) {
        synchronized (waitFileSync) {
            fileDone = true;
            fileSuccess = false;
            waitFileSync.notifyAll();
        }
    }
}

@Override
public void controllerUpdate(ControllerEvent evt) {
    if (evt instanceof ConfigureCompleteEvent
            || evt instanceof RealizeCompleteEvent
            || evt instanceof PrefetchCompleteEvent) {
        synchronized (waitSync) {
            stateTransitionOK = true;
            waitSync.notifyAll();
        }
    } else if (evt instanceof ResourceUnavailableEvent) {
        synchronized (waitSync) {
            stateTransitionOK = false;
            waitSync.notifyAll();
        }
    } else if (evt instanceof EndOfMediaEvent) {
        evt.getSourceController().stop();
        evt.getSourceController().close();
    }

}
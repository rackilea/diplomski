/*
*Start the recording
*/
public void recordVideo() {
     IConnection conn = Red5.getConnectionLocal();
     //get the stream published by the id "publishId"
     ClientBroadcastStream stream = (ClientBroadcastStream) getBroadcastStream(conn.getScope(), "publishId");
     try {
        // Save the stream to disk.
        stream.saveAs("streamName", false);
    } catch (Exception e) {
        throw new RuntimeException(e.getMessage());
    }
}
/*
*Stop the recording
*/
public void stopRecording(){
     IConnection conn = Red5.getConnectionLocal();
     ClientBroadcastStream stream = (ClientBroadcastStream) getBroadcastStream(conn.getScope(), "publishId");
    // Stop recording.
    stream.stopRecording();
    stream.stop();
}
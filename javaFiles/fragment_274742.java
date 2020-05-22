class ApplicationState {

 enum ProcessState {
  READ_DONE,
  PROCESSING_STARTED,
  PROCESSING_ENDED,
  ANOTHER_STATE;
 }

 private List<String> filesDone, filesToDo;
 private String currentlyProcessingFile;
 private ProcessState currentProcessState;
}
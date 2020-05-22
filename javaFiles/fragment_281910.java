private val recordWriter: RecordWriter[Void, InternalRow] = {
  val outputFormat = {
    new ParquetOutputFormat[InternalRow]() {
      // ...
      override def getDefaultWorkFile(context: TaskAttemptContext, extension: String): Path = {
        // ..
        //  prefix is hard-coded here:
        new Path(path, f"part-r-$split%05d-$uniqueWriteJobId$bucketString$extension")
    }
  }
}
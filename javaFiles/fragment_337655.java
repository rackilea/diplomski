public class WholeFileInputFormat extends CombineFileInputFormat<NullWritable, Text>{

        @Override
        protected boolean isSplitable(JobContext context, Path file) {
            return false;
        }

/**
   * Creates a CombineFileRecordReader to read each file assigned to this InputSplit.
   * Note, that unlike ordinary InputSplits, split must be a CombineFileSplit, and therefore
   * is expected to specify multiple files.
   *
   * @param split The InputSplit to read.  Throws an IllegalArgumentException if this is
   *        not a CombineFileSplit.
   * @param context The context for this task.
   * @return a CombineFileRecordReader to process each file in split.
   *         It will read each file with a WholeFileRecordReader.
   * @throws IOException if there is an error.
   */

    @Override
    public RecordReader<NullWritable, Text> createRecordReader(
            InputSplit split, TaskAttemptContext context) throws IOException {

        if (!(split instanceof CombineFileSplit)) {
              throw new IllegalArgumentException("split must be a CombineFileSplit");
            }
            return new CombineFileRecordReader<NullWritable, Text>((CombineFileSplit) split, context, WholeFileRecordReader.class);
    }

    }
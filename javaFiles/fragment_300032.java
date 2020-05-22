public class HdfsUtil {
    /**
     * Estimates the number of splits by taking the size of the paths and dividing by the splitSize.
     *
     * @param paths
     * @param configuration
     * @param splitSize
     * @return
     * @throws IOException
     */
    public static long getNumOfSplitsForInputs(Path[] paths, Configuration configuration, long splitSize) throws IOException
    {
        long size = getSizeOfPaths(paths, configuration);
        long splits = (int) Math.ceil( size / (splitSize)) ;
        return splits;
    }

    public static long getSizeOfPaths(Path[] paths, Configuration configuration) throws IOException
    {
        long totalSize = 0L;

        for(Path path: paths)
        {
           totalSize += getSizeOfDirectory(path, configuration);
        }
        return totalSize;
    }
// here you can give hbase path folder which was described through shell
        public static long getSizeOfDirectory(Path path, Configuration configuration) throws IOException {
            //Get the file size of the unannotated Edges
            FileSystem fileSystem = FileSystem.get(configuration);
            long size  = fileSystem.getContentSummary(path).getLength();
/**static String    byteCountToDisplaySize(BigInteger size)
Returns a human-readable version of the file size, where the input represents a specific number of bytes.**/
System.out.println(FileUtils.byteCountToDisplaySize(size))
            return size;
        }
    }
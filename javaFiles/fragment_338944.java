public class SongsReducer extends Reducer<Text, Text, Text, Text> { 
    public void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {
        boolean first = true;
        StringBuilder songs = new StringBuilder();;
        for (Text val : values){
              if (!first)
                songs.append(",");
              first=false;
              songs.append(val.toString());
            }

        context.write(key, new Text(songs.toString()));
}
}
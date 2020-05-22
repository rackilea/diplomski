@Override
protected void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException {

    StringTokenizer line = new StringTokenizer(value.toString(), ",\t");

    if (line.countTokens() > 0) {
        word.set(line.nextToken());

        if (line.hasMoreTokens())
            max.set(Integer.parseInt(line.nextToken()));

        context.write(word, max);
    }
}
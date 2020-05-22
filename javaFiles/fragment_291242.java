Path path = new Path("file:///tmp/puzzling.seq");

    try (FSDataOutputStream stream = fs.create(path)) {
        try (SequenceFile.Writer writer = SequenceFile.createWriter(conf, Writer.stream(stream),
                Writer.keyClass(IntWritable.class), Writer.valueClass(NullWritable.class))) {

            for (int i = 0; i < 1024; i++) {
                writer.append(new IntWritable(i), NullWritable.get());
            }
        }
    }

    try (SequenceFile.Reader reader = new SequenceFile.Reader(conf, Reader.file(path))) {
        Class<?> keyClass = reader.getKeyClass();
        Class<?> valueClass = reader.getValueClass();

        WritableComparable<?> rKey = (WritableComparable<?>) ReflectionUtils.newInstance(keyClass, conf);
        Writable rValue = (Writable) ReflectionUtils.newInstance(valueClass, conf);
        while (reader.next(rKey, rValue)) {
            System.out.printf("%s = %s\n", rKey, rValue);
        }

    }
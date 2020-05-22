try {
            Path path = new Path(uri);

            IntWritable key = new IntWritable();
            Text value = new Text();

            /** First, Check a file already exists.
             * If there is not exists in hdfs, writer object is created.
             * */
            if (!fs.exists(path)) {
                writer = SequenceFile.createWriter(config, SequenceFile.Writer.file(path), SequenceFile.Writer.keyClass(key.getClass()),
                        ArrayFile.Writer.valueClass(value.getClass()));

                writer.append(new IntWritable(11), new Text("test"));
                writer.append(new IntWritable(12), new Text("test2"));
                writer.close();
            } else {
                logger.info(path + " already exists.");
            }

            /** Create a SequenceFile Reader object.*/
            reader = new SequenceFile.Reader(config, SequenceFile.Reader.file(path));

            while (reader.next(key, value)) {
                System.out.println(key + "\t" + value);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(writer);
            IOUtils.closeStream(reader);
        }
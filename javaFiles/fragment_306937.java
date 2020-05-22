ZipFileDataFormat zf = new ZipFileDataFormat();
zf.setUsingIterator(true);

from(source).choice().when(isZipFile)
            .unmarshal(zf)
            .split(bodyAs(Iterator.class))
            .streaming()
            .convertBodyTo(String.class)
            .process(md5HeadersProcessor)
            .process(camelS3HeadersProcessor)
            .to(destination)
            .log("Uploading file ${file:name} completed...")
            .end()
            .endChoice()
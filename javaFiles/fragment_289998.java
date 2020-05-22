Process process = new ProcessBuilder()
        .command("/usr/local/bin/kafka-consumer-groups", "--bootstrap-server", "localhost:9092",
                "--describe", "--group", "siTestGroup")
        .start();
InputStream inputStream = process.getInputStream();
process.waitFor(10, TimeUnit.SECONDS);
ByteArrayOutputStream baos = new ByteArrayOutputStream();
FileCopyUtils.copy(inputStream, baos);
System.out.println(new String(baos.toByteArray()));
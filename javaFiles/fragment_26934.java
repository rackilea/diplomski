try {
        config.save(new File(filePath));


        byte[] readIn = Files.readAllBytes(Paths.get(filePath));
        String replacer = new String(readIn, StandardCharsets.UTF_8).replace("\\\\\\\\", "\\");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, false), "UTF-8"));
        bw.write(replacer);
        bw.close();

} catch (ConfigurationException | IOException e) {
        e.printStackTrace();
}
for(String words: split) {
    if (!words.isEmpty()) { // Here!
        firstChar = String.valueOf(words.charAt(0));
        try {
            ctx.write(new Text(firstChar), new IntWritable(1));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
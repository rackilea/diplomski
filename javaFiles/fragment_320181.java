File dir = new File(getVideoPath(condition));
Random gen = new Random();

File[] videos = dir.listFiles();

int random_index = gen.nextInt(videos.length);

return videos[random_index];
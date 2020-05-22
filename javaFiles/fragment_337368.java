byte[] image = loadImage();
int chunkSize = 4096; // 4k
int chunks = image.length / chunkSize;
for (int i=0; i<chucks; ++i) {
  os.write(image, i*chunkSize, chunkSize);
}
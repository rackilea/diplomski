import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.event.IIOReadProgressListener;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class MultipleJPEGDecoding {
    private static int threads = Runtime.getRuntime().availableProcessors();
    private static ExecutorService executorService = Executors.newFixedThreadPool(threads * 4);

    public static void main(final String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            final int index = i;

            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        ImageInputStream stream = ImageIO.createImageInputStream(new File(args[index % args.length]));
                        try {
                            Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);
                            if (!readers.hasNext()) {
                                System.err.println("No reader!");
                                return;
                            }

                            ImageReader reader = readers.next();
                            reader.setInput(stream);
                            reader.addIIOReadProgressListener(new ProgressListener(index));

                            try {
                                reader.read(0);
                            }
                            finally {
                                reader.dispose();
                            }
                        }
                        finally {
                            stream.close();
                        }
                    }
                    catch (Exception e) {
                        System.err.printf("Error reading %d\n", index);
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }

    static class ProgressListener implements IIOReadProgressListener {
        final static AtomicInteger simultaneous = new AtomicInteger(0);

        final int index;
        int nextProgress = 25;

        public ProgressListener(int index) {
            this.index = index;
        }

        public void imageStarted(ImageReader source, int imageIndex) {
            int inProgress = simultaneous.incrementAndGet();
            System.err.printf("Started reading image %d (now decoding %d images simultaneous)...\n", index, inProgress);
        }

        public void imageComplete(ImageReader source) {
            int inProgress = simultaneous.decrementAndGet();
            System.err.printf("Done reading image %d%s.\n", index, inProgress > 0 ? String.format(" (still decoding %d other images)", inProgress) : "");
        }

        public void imageProgress(ImageReader source, float percentageDone) {
            if (percentageDone > nextProgress) {
                int inProgress = simultaneous.get();
                System.err.printf("Progress on image %d (now decoding %d images simultaneous)...\n", index, inProgress);
                nextProgress += 25;
            }
        }

        public void sequenceStarted(ImageReader source, int minIndex) {
        }

        public void sequenceComplete(ImageReader source) {
        }

        public void thumbnailStarted(ImageReader source, int imageIndex, int thumbnailIndex) {
        }

        public void thumbnailProgress(ImageReader source, float percentageDone) {
        }

        public void thumbnailComplete(ImageReader source) {
        }

        public void readAborted(ImageReader source) {
        }
    }
}
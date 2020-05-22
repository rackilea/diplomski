import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class ConcatImages {
    private static final int POS_FILE_SIZE = 2;
    private static final int POS_START_CONTENT = 10;
    private static final int POS_WIDTH = 18;
    private static final int POS_HEIGHT = 22;

    public static void main(final String[] args) throws IOException, IllegalAccessException {
        final String[] files = {
            "image1.bmp", "image2.bmp", "image3.bmp"
        };

        concatBMPFiles(files, "result_image.bmp");
    }

    private static void concatBMPFiles(final String[] filenames, final String resultFilename) throws IOException, IllegalAccessException {
        final byte[][] fileContents = new byte[filenames.length][];

        int i = 0;

        for (final String file : filenames) {
            fileContents[i++] = readImageBytes(file);
        }

        final byte[] result = concatBMPImageData(fileContents);

        final OutputStream out = new BufferedOutputStream(new FileOutputStream(resultFilename));
        out.write(result);
        out.close();
    }

    private static byte[] concatBMPImageData(final byte[] ... imageDatas) throws IllegalAccessException {
        int newFileSize = 0;
        int newHeight = 0;
        int compWidth = -1;

        for (final byte[] imageData : imageDatas) {
            if (compWidth > -1) {
                // remove header length for all images, except the first
                newFileSize -=  getInt(imageData, POS_START_CONTENT);

                if (compWidth != getInt(imageDatas[0], POS_WIDTH)) {
                    throw new IllegalAccessException("All images must have the same width!");
                }
            } else {
                compWidth = getInt(imageDatas[0], POS_WIDTH);
            }

            newHeight += getInt(imageData, POS_HEIGHT);
            newFileSize += imageData.length;
        }

        newFileSize += getInt(imageDatas[0], POS_START_CONTENT);

        final byte[] result = new byte[newFileSize];
        int idx = 0;

        // read header from first image
        for (int i = 0; i < getInt(imageDatas[0], POS_START_CONTENT); i++) {
            result[idx++] = imageDatas[0][i];
        }

        // read content from all images
        for (int fIdx = imageDatas.length - 1; fIdx >= 0; fIdx--) {
            final int startContentDest = getInt(imageDatas[fIdx], POS_START_CONTENT);

            for (int i = startContentDest; i < imageDatas[fIdx].length; i++) {
                result[idx++] = imageDatas[fIdx][i];
            }
        }

        // set new file size to header
        setInt(result, POS_FILE_SIZE, newFileSize);

        // set new height to header
        setInt(result, POS_HEIGHT, newHeight);

        return result;
    }

    private static byte[] readImageBytes(final String filename) throws IOException {
        final BufferedImage image = ImageIO.read(new File(filename));
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ImageIO.write(image, "bmp", baos);

        return baos.toByteArray();
    }

    private static int getInt(byte[] src, int start) {
        return ((0xFF & src[start + 3]) << 24) |
            ((0xFF & src[start + 2]) << 16) |
            ((0xFF & src[start + 1]) << 8) |
            (0xFF & src[start]);
    }

    private static void setInt(byte[] src, int start, int newValue) {
        byte[] value = intToByteArr(newValue);

        src[start] = value[3];
        src[start + 1] = value[2];
        src[start + 2] = value[1];
        src[start + 3] = value[0];
    }

    private static byte[] intToByteArr(int value) {
        byte[] result = new byte[4];

        for (int i = 0; i < 4; i++) {
            int shift = i << 3;
            result[3 - i] = (byte) ((value & (0xff << shift)) >>> shift);
        }

        return result;
    }
}
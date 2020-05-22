import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.icafe4j.image.meta.Metadata;
import com.icafe4j.image.meta.exif.Exif;
import com.icafe4j.image.meta.jpeg.JpegExif;
import com.icafe4j.image.meta.exif.ExifTag;
import com.icafe4j.image.tiff.TiffTag;
import com.icafe4j.image.tiff.FieldType;

public class TestWindowsXP {

 public static void main(String[] args) throws IOException {

    FileInputStream fin = new FileInputStream(Fm_filePathIn);
    FileOutputStream fout = new FileOutputStream(Fm_filePathOut);

    List<Metadata> metaList = new ArrayList<Metadata>();

    Exif exif = new JpegExif();

    exif.addImageField(TiffTag.WINDOWS_XP_AUTHOR, FieldType.WINDOWSXP, "Toto");
    exif.addImageField(TiffTag.WINDOWS_XP_KEYWORDS, FieldType.WINDOWSXP, "Copyright;Authorbisou");
    // Insert ThumbNailIFD
    // Since we don't provide thumbnail image, it will be created later from the input stream
    exif.setThumbnailRequired(true);

    metaList.add(exif);
    Metadata.insertMetadata(metaList, fin, fout);

    fin.close();
    fout.close();
 }
}
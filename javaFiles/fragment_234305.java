import java.io.IOException;
    import java.util.List;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;

    import com.icafe4j.image.meta.Metadata;
    import com.icafe4j.image.meta.MetadataEntry;
    import com.icafe4j.image.meta.MetadataType;
    import com.icafe4j.image.meta.iptc.IPTCDataSet;
    import com.icafe4j.image.meta.iptc.IPTCApplicationTag;

    public class InsertIPTC {

        public static void main(String[] args) throws IOException {
           FileInputStream fin = new FileInputStream("C:/Users/rajab/Desktop/test/ibo.jpeg");
           FileOutputStream fout = new FileOutputStream("C:/Users/rajab/Desktop/test/ibo/ibo.jpeg");

           Metadata.insertIPTC(fin, fout, createIPTCDataSet(), true);
        }
        private static List<IPTCDataSet> createIPTCDataSet() {
            List<IPTCDataSet> iptcs = new ArrayList<IPTCDataSet>();
            iptcs.add(new IPTCDataSet(IPTCApplicationTag.COPYRIGHT_NOTICE, "Copyright 2014-2016, yuwen_66@yahoo.com"));
            iptcs.add(new IPTCDataSet(IPTCApplicationTag.OBJECT_NAME, "ICAFE"));
            iptcs.add(new IPTCDataSet(IPTCApplicationTag.KEY_WORDS, "Welcome 'icafe' user!"));

            return iptcs;
        }
    }
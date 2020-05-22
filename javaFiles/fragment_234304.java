import java.io.IOException;
    import java.util.List;
    import java.util.Map;
    import java.util.Iterator;

    import com.icafe4j.image.meta.Metadata;
    import com.icafe4j.image.meta.MetadataEntry;
    import com.icafe4j.image.meta.MetadataType;
    import com.icafe4j.image.meta.iptc.IPTC;

    public class ExtractIPTC {

        public static void main(String[] args) throws IOException {
            Map<MetadataType, Metadata> metadataMap = Metadata.readMetadata(args[0]);
            IPTC iptc = (IPTC)metadataMap.get(MetadataType.IPTC);

            if(iptc != null) {
                Iterator<MetadataEntry> iterator = iptc.iterator();

                while(iterator.hasNext()) {
                    MetadataEntry item = iterator.next();
                    printMetadata(item, "", "     ");
                }
            }   
        }
        private void printMetadata(MetadataEntry entry, String indent, String increment) {
            logger.info(indent + entry.getKey() (StringUtils.isNullOrEmpty(entry.getValue())? "" : ": " + entry.getValue()));
            if(entry.isMetadataEntryGroup()) {
                 indent += increment;
                 Collection<MetadataEntry> entries = entry.getMetadataEntries();
                 for(MetadataEntry e : entries) {
                    printMetadata(e, indent, increment);
                 }          
            }
        }   
    }
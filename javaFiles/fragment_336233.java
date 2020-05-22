import com.ximpleware.*;


public class VTDParser {
      // private final Logger LOG = LoggerFactory.getLogger(VTDParser.class);

        private final VTDGen vg;
        private final AutoPilot ap;
        public VTDParser() throws VTDException{
            vg = new VTDGen();
            ap = new AutoPilot();
            ap.selectXPath("/a/b/c");// this is how you compile xpath w/o binding to an XML doc
        }

        public String parse(final String data, final AutoPilot ap1) {
            vg.setDoc(data.getBytes());
            try {
                vg.parse(true);
            } catch (final ParseException e) {
                LOG.error(e.toString());
            }

            final VTDNav vn = vg.getNav();
            ap1.bind(vn);
            try {
                while (ap.evalXPath() != -1) {
                    final int val = vn.getText();
                    if (val != -1) {
                        return vn.toNormalizedString(val);
                    }
                }
            } catch (XPathEvalException | NavException e) {
                LOG.error(e.toString());
            }
            ap.resetXPath();// reset your xpath here
            return null;
        }
}
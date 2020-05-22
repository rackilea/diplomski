import java.io.File;
import java.text.NumberFormat;

public class TestFileSize {

    public static void main(String[] args) {
        File test1 = new File("C:/pagefile.sys");
        File test2 = new File("C:/hiberfil.sys");

        System.out.println(test1.length() + " / " + ByteFormatter.format(test1.length()));
        System.out.println(test2.length() + " / " + ByteFormatter.format(test2.length()));

    }

    public static class ByteFormatter {

        public static final long KILO_BYTES = 1024;
        public static final long MEGA_BYTES = 1024 * KILO_BYTES;
        public static final long GIGA_BYTES = 1024 * MEGA_BYTES;
        public static final long TERA_BYTES = 1024 * GIGA_BYTES;
        public enum Format {

            TeraBytes(TERA_BYTES),
            GigaBytes(GIGA_BYTES),
            MegaBytes(MEGA_BYTES),
            KiloBytes(KILO_BYTES);
            private long multiplier;

            private Format(long multiplier) {
                this.multiplier = multiplier;
            }

            public long getMultiplier() {
                return multiplier;
            }
        }

        public static String format(long bytes) {
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(0);
            String format = bytes + " bytes";
            if (bytes / TERA_BYTES > 0) {
                format = nf.format((double) bytes / TERA_BYTES) + " tb";
            } else if (bytes / GIGA_BYTES > 0) {
                format = nf.format((double) bytes / GIGA_BYTES) + " gb";
            } else if (bytes / MEGA_BYTES > 0) {
                format = nf.format((double) bytes / MEGA_BYTES) + " mb";
            } else if (bytes / KILO_BYTES > 0) {
                format = nf.format((double) bytes / KILO_BYTES) + " kb";
            } else {
                format = nf.format(bytes) + " bytes";
            }

            return format;
        }

        public static String formatMegaBytes(long lMegaBytes) {

            return format((long) ((double) lMegaBytes * MEGA_BYTES));

        }

        public static String formatKiloBytes(long kbytes) {

            return format(kbytes * KILO_BYTES);

        }

        public static String formatGigaBytes(long gbytes) {

            return format(gbytes * GIGA_BYTES);

        }

        public static String formatTeraBytes(long gbytes) {

            return format(gbytes * TERA_BYTES);

        }

        public static long toBytes(String value, Format format) {

            long multipler = format.getMultiplier();

            long bytes = (long) (Double.parseDouble(value.trim()) * multipler);

            return bytes;

        }

        public static long toBytes(String sValue) {

            long lBytes = 0;

            if (sValue.indexOf(" ") > -1) {

                String sElements[] = sValue.split(" ");

                lBytes = Long.parseLong(sElements[0]);

                if (sElements[1].toLowerCase().startsWith("gb")) {

                    lBytes *= GIGA_BYTES;

                } else if (sElements[1].toLowerCase().startsWith("mb")) {

                    lBytes *= MEGA_BYTES;

                } else if (sElements[1].toLowerCase().startsWith("kb")) {

                    lBytes *= KILO_BYTES;

                }

            } else {

                sValue = sValue.trim();
                long lMultiplier = 1;
                String sBytes = null;

                if (sValue.toLowerCase().endsWith("gb")) {

                    sBytes = sValue.substring(0, sValue.toLowerCase().indexOf("gb"));
                    lMultiplier = GIGA_BYTES;

                } else if (sValue.toLowerCase().endsWith("mb")) {

                    sBytes = sValue.substring(0, sValue.toLowerCase().indexOf("mb"));
                    lMultiplier = MEGA_BYTES;

                } else if (sValue.toLowerCase().endsWith("kb")) {

                    sBytes = sValue.substring(0, sValue.toLowerCase().indexOf("kb"));
                    lMultiplier = KILO_BYTES;

                }

                lBytes = Long.parseLong(sBytes);

                lBytes *= lMultiplier;

            }

            return lBytes;

        }
    }
}
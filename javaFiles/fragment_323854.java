import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import junit.framework.Assert;


public class RegExSnippet {

    private static Charset UTF8 = Charset.forName("UTF8");

    @Test
    public void testByteBufferRegEx() throws UnsupportedEncodingException {

        // this UTF8 byte encoding of test string
        byte[] bytes = ("lkfmd;wmf;qmfqv amwfqwmf;c "
        + "<tag>This is some non ASCII text 'кирилицеский текст'</tag>"
        + "kjnfdlwncdlka-lksnflanvf ").getBytes(UTF8);

        ByteBuffer bb = ByteBuffer.wrap(bytes);

        ByteSeqWrapper bsw = new ByteSeqWrapper(bb);

        // pattern should contain only LATIN1 characters
        Matcher m = Pattern.compile("<tag>(.*)</tag>").matcher(bsw);

        Assert.assertTrue(m.find());

        String body = m.group(1);

        // extracted part is properly decoded as UTF8
        Assert.assertEquals("This is some non ASCII text 'кирилицеский текст'", body);
    }

    public static class ByteSeqWrapper implements CharSequence {

        final ByteBuffer buffer;

        public ByteSeqWrapper(ByteBuffer buf) {
            this.buffer = buf;
        }

        @Override
        public int length() {
            return buffer.remaining();
        }

        @Override
        public char charAt(int index) {
            return (char) (0xFF & buffer.get(index));
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            ByteBuffer bb = buffer.duplicate();
            bb.position(bb.position() + start);
            bb.limit(bb.position() + (end - start));
            return new ByteSeqWrapper(bb);
        }

        @Override
        public String toString() {
            // a little hack to apply proper encoding
            // to a parts extracted by matcher
            CharBuffer cb = UTF8.decode(buffer);
            return cb.toString();
        }
    }
}
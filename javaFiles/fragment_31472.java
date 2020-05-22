package ch.beo.streaming.swing;

import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;

import javax.media.Buffer;
import javax.media.Format;
import javax.media.format.VideoFormat;
import javax.media.protocol.ContentDescriptor;
import javax.media.protocol.PullBufferStream;

import ch.beo.streaming.base.ControlHelper;

/**
 * Implements a {@link javax.media.protocol.PullBufferStream PullBufferStream}
 * based on a given {@link java.awt.Component Component}. The current visual
 * representation of the {@link java.awt.Component component} is continuously
 * provided as a JPEG image.
 */
public class ComponentBufferStream implements PullBufferStream {
    private static final int KEY_FRAME_RATE = 100;
    private final Component component;
    private int frameCount = -1;

    public ComponentBufferStream(Component component) {
        this.component = component;
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.SourceStream#endOfStream()
     */
    @Override
    public boolean endOfStream() {
        return false;
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.SourceStream#getContentDescriptor()
     */
    @Override
    public ContentDescriptor getContentDescriptor() {
        return new ContentDescriptor(ContentDescriptor.RAW);
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.SourceStream#getContentLength()
     */
    @Override
    public long getContentLength() {
        return LENGTH_UNKNOWN;
    }

    /*
     * (non-Javadoc)
     * @see javax.media.Controls#getControl(java.lang.String)
     */
    @Override
    public Object getControl(String controlType) {
        return ControlHelper.getControl(this, controlType);
    }

    /*
     * (non-Javadoc)
     * @see javax.media.Controls#getControls()
     */
    @Override
    public Object[] getControls() {
        return ControlHelper.getControls(this);
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.PullBufferStream#getFormat()
     */
    @Override
    public Format getFormat() {
        Dimension size = component.getSize();
        return new VideoFormat(VideoFormat.JPEG, size, Format.NOT_SPECIFIED, Format.byteArray, 0.1f);
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.PullBufferStream#read(javax.media.Buffer)
     */
    @Override
    public void read(Buffer buffer) throws IOException {
        byte[] image = JpegHelper.componentToJpeg(component);
        byte[] data = (byte[]) buffer.getData();
        if (data != null && data.length - buffer.getOffset() >= image.length) {
            System.arraycopy(image, 0, data, buffer.getOffset(), image.length);
        } else {
            buffer.setData(image);
            buffer.setOffset(0);
        }
        buffer.setLength(image.length);
        buffer.setFormat(getFormat());
        if (isKeyFrame()) {
            buffer.setFlags(buffer.getFlags() | Buffer.FLAG_KEY_FRAME);
        }
    }

    private boolean isKeyFrame() {
        if (++frameCount % KEY_FRAME_RATE == 0) {
            frameCount = 0;
            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.PullBufferStream#willReadBlock()
     */
    @Override
    public boolean willReadBlock() {
        Dimension dimension = component.getSize();
        return dimension.height > 0 && dimension.width > 0;
    }
}
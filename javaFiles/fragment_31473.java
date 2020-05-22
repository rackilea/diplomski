package ch.beo.streaming.swing;

import java.awt.Component;
import java.io.IOException;

import javax.media.Time;
import javax.media.protocol.PullBufferDataSource;
import javax.media.protocol.PullBufferStream;

import ch.beo.streaming.base.ControlHelper;

/**
 * Implements a {@link javax.media.protocol.PullBufferDataSource
 * PullBufferDataSource} based on a given {@link java.awt.Component Component}.
 * The current visual representation of the {@link java.awt.Component component}
 * is continuously provided as a JPEG image.
 */
public class ComponentDataSource extends PullBufferDataSource {
    private final PullBufferStream[] streams;

    public ComponentDataSource(Component component) {
        streams = new PullBufferStream[] { new ComponentBufferStream(component) };
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.DataSource#connect()
     */
    @Override
    public void connect() throws IOException {
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.DataSource#disconnect()
     */
    @Override
    public void disconnect() {
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.DataSource#getContentType()
     */
    @Override
    public String getContentType() {
        return streams[0].getContentDescriptor().getContentType();
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.DataSource#getControl(java.lang.String)
     */
    @Override
    public Object getControl(String controlType) {
        return ControlHelper.getControl(this, controlType);
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.DataSource#getControls()
     */
    @Override
    public Object[] getControls() {
        return ControlHelper.getControls(this);
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.DataSource#getDuration()
     */
    @Override
    public Time getDuration() {
        return Time.TIME_UNKNOWN;
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.DataSource#start()
     */
    @Override
    public void start() throws IOException {
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.DataSource#stop()
     */
    @Override
    public void stop() throws IOException {
    }

    /*
     * (non-Javadoc)
     * @see javax.media.protocol.PullBufferDataSource#getStreams()
     */
    @Override
    public PullBufferStream[] getStreams() {
        return streams;
    }
}
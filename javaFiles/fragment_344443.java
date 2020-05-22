//
// $Id: ByteBufferOutputStream.java 5829 2009-06-20 21:09:34Z mdb $
//
// Narya library - tools for developing networked games
// Copyright (C) 2002-2009 Three Rings Design, Inc., All Rights Reserved
// http://www.threerings.net/code/narya/
//
// This library is free software; you can redistribute it and/or modify it
// under the terms of the GNU Lesser General Public License as published
// by the Free Software Foundation; either version 2.1 of the License, or
// (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

package misc;

import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

import org.apache.mina.core.buffer.IoBuffer;

/**
 * Stores output in an {@link ByteBuffer} that grows automatically to accommodate the data.
 */
public class ByteBufferOutputStream extends OutputStream
{
    /**
     * Creates a new byte buffer output stream.
     */
    public ByteBufferOutputStream ()
    {
        _buffer = IoBuffer.allocate(INITIAL_BUFFER_SIZE);
    }

    /**
     * Returns a reference to the underlying buffer.
     */
    public IoBuffer getBuffer ()
    {
        return _buffer;
    }

    /**
     * Flips and returns the buffer.  The returned buffer will have a position of zero and a limit
     * equal to the number of bytes written.  Call {@link #reset} to reset the buffer before
     * writing again.
     */
    public IoBuffer flip ()
    {
        return _buffer.flip();
    }

    /**
     * Resets our internal buffer.
     */
    public void reset ()
    {
        _buffer.clear();
    }

    @Override // documentation inherited
    public void write (int b)
    {
        try {
            _buffer.put((byte)b);
        } catch (BufferOverflowException boe) {
            expand(1);
            _buffer.put((byte)b);
        }
    }

    @Override // documentation inherited
    public void write (byte[] b, int off, int len)
    {
        // sanity check the arguments
        if ((off < 0) || (off > b.length) || (len < 0) ||
            ((off + len) > b.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }

        try {
            _buffer.put(b, off, len);
        } catch (BufferOverflowException boe) {
            expand(len);
            _buffer.put(b, off, len);
        }
    }

    /**
     * Expands our buffer to accomodate the specified capacity.
     */
    protected final void expand (int needed)
    {
        _buffer.expand(needed);
    }

    /** The buffer in which we store our frame data. */
    protected IoBuffer _buffer;

    /** The default initial size of the internal buffer. */
    protected static final int INITIAL_BUFFER_SIZE = 32;
}
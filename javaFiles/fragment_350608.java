private void GenerateBatches() {
        if(glyphs.size() < 1) return;

        // Create Arrays
        ByteBuffer bb = BufferUtils.createByteBuffer(6 * glyphs.size() * VertexSpriteBatch.Size);
        SpriteBatchCall call = new SpriteBatchCall(0, glyphs.get(0).Texture, batches);
        glyphs.get(0).VTL.AppendToBuffer(bb);
        glyphs.get(0).VTR.AppendToBuffer(bb);
        glyphs.get(0).VBL.AppendToBuffer(bb);
        glyphs.get(0).VBL.AppendToBuffer(bb);
        glyphs.get(0).VTR.AppendToBuffer(bb);
        glyphs.get(0).VBR.AppendToBuffer(bb);
        emptyGlyphs.add(glyphs.get(0));

        int gc = glyphs.size();
        for(int i = 1; i < gc; i++) {
            SpriteGlyph glyph = glyphs.get(i);
            call = call.Append(glyph, batches);
            glyph.VTL.AppendToBuffer(bb);
            glyph.VTR.AppendToBuffer(bb);
            glyph.VBL.AppendToBuffer(bb);
            glyph.VBL.AppendToBuffer(bb);
            glyph.VTR.AppendToBuffer(bb);
            glyph.VBR.AppendToBuffer(bb);
            emptyGlyphs.add(glyphs.get(i));
        }
        bb.flip();
        glyphs = null;

        // Set The Buffer Data
        glBindBuffer(BufferTarget.ArrayBuffer, vbo);
        if(gc > glyphCapacity) {
            glyphCapacity = gc * 2;
            glBufferData(
                    BufferTarget.ArrayBuffer,
                    (glyphCapacity * 6) * VertexSpriteBatch.Size,
                    bufUsage
                    );
        }
        glBufferSubData(BufferTarget.ArrayBuffer, 0, bb);
        GLBuffer.Unbind(BufferTarget.ArrayBuffer);
    }
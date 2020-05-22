if (contentBuffer.hasRemaining()) {
        return AjpMessageUtils.appendContentAndTrim(memoryManager,
                encodedBuffer, contentBuffer);
    } else if (encodedBuffer == null) {
        encodedBuffer = Buffers.EMPTY_BUFFER;
    }
IntBuffer size = JEmalloc.je_malloc(2 * Integer.BYTES).asIntBuffer();
long address = MemoryUtil.memAddress(size);

[...]

JEmalloc.nje_free(address);
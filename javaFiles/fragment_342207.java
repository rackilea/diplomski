long startOffset = fileDescriptor.getStartOffset();
long declaredLength = fileDescriptor.getDeclaredLength();
MappedByteBuffer mappedByteBuffer = fileChannel.map(
        FileChannel.MapMode.READ_ONLY, 
        startOffset, 
        declaredLength);
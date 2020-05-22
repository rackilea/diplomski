function playBytes(bytes) {
    var floats = new Float32Array(bytes.length);

    bytes.forEach(function( sample, i ) {
        floats[i] = sample / 32767;
    });

    var buffer = context.createBuffer(1, floats.length, 48000),
        source = context.createBufferSource();

    buffer.getChannelData(0).set(floats);
    source.buffer = buffer;
    source.connect(context.destination);
    source.start(0);
}
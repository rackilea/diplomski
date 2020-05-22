async sign(msg) {
    const encoder = new TextEncoder('utf-8');
    const msgBuffer = encoder.encode(msg.toString());
    const signedBuffer = await ECDSA.sign(this.keys.privateKey, msgBuffer);
    const signedArray = Array.from(new Uint8Array(signedBuffer));
    return Encryption.byteToHexString(signedArray);
}
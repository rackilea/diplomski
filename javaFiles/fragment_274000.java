class MyClass(private val compressor: SignatureCompressor) {

    override fun signatureSigned(name: String, svgSignature: String, bitmapSignature: Bitmap, signatureType: SignatureType) {
        val svgSignatureGzipped = compressor.compress(svgSignature)
        ...
    }

}
class MyClass {

    override fun signatureSigned(name: String, svgSignature: String, bitmapSignature: Bitmap, signatureType: SignatureType) {
        val svgSignatureGzipped = CompressionTools.gzipCompress(svgSignature)
        ...
    }

}
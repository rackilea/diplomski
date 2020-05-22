interface SignatureCompressor {
    fun compress(signature: String)
}

class GZipSignatureCompressor : SignatureCompressor {
    override fun compress(signature: String) {
        return CompressionTools.gzipCompress(signature)
    } 
}
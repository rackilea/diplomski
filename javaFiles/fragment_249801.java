class FaceNetStorage @Throws(IOException::class)
constructor() {
    private val intValues = IntArray(IMAGE_HEIGHT * IMAGE_WIDTH)
    private var imgData: ByteBuffer? = null

    private var tfliteModel: MappedByteBuffer? = null
    private var tflite: Interpreter? = null
    private val tfliteOptions = Interpreter.Options()

    init {
        val str = Environment.getExternalStorageDirectory().toString()+"/Facenet"
        val sd_main = File(str)
        var success = true
        if (!sd_main.exists()) {
            success = sd_main.mkdir()
        }
        if (success) {
            val sd = File(str+"/"+MODEL_PATH)
            tfliteModel = loadModelFile(sd)
            tflite = Interpreter(tfliteModel!!, tfliteOptions)
            imgData = ByteBuffer.allocateDirect(
                    BATCH_SIZE
                            * IMAGE_HEIGHT
                            * IMAGE_WIDTH
                            * NUM_CHANNELS
                            * NUM_BYTES_PER_CHANNEL)
            imgData!!.order(ByteOrder.nativeOrder())
        }
    }

    @Throws(IOException::class)
    private fun loadModelFile(file: File): MappedByteBuffer {
        val inputStream = FileInputStream(file)
        val fileChannel = inputStream.channel
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size())
    }

    private fun convertBitmapToByteBuffer(bitmap: Bitmap) {
        if (imgData == null) {
            return
        }
        imgData!!.rewind()
        bitmap.getPixels(intValues, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        // Convert the image to floating point.
        var pixel = 0
        for (i in 0 until IMAGE_HEIGHT) {
            for (j in 0 until IMAGE_WIDTH) {
                val `val` = intValues[pixel++]
                addPixelValue(`val`)
            }
        }
    }

    private fun addPixelValue(pixelValue: Int) {
        imgData!!.putFloat((pixelValue shr 16 and 0xFF) / 255.0f)
        imgData!!.putFloat((pixelValue shr 8 and 0xFF) / 255.0f)
        imgData!!.putFloat((pixelValue and 0xFF) / 255.0f)
    }

    fun inspectModel() {
        val tag = "Model Inspection"
        Log.i(tag, "Number of input tensors: " + tflite!!.inputTensorCount.toString())
        Log.i(tag, "Number of output tensors: " + tflite!!.outputTensorCount.toString())

        Log.i(tag, tflite!!.getInputTensor(0).toString())
        Log.i(tag, "Input tensor data type: " + tflite!!.getInputTensor(0).dataType())
        Log.i(tag, "Input tensor shape: " + Arrays.toString(tflite!!.getInputTensor(0).shape()))
        Log.i(tag, "Output tensor 0 shape: " + Arrays.toString(tflite!!.getOutputTensor(0).shape()))
    }

    private fun resizedBitmap(bitmap: Bitmap, height: Int, width: Int): Bitmap {
        return Bitmap.createScaledBitmap(bitmap, width, height, true)
    }

    private fun croppedBitmap(bitmap: Bitmap, upperCornerX: Int, upperCornerY: Int, height: Int, width: Int): Bitmap {
        return Bitmap.createBitmap(bitmap, upperCornerX, upperCornerY, width, height)
    }

    private fun run(bitmap: Bitmap): Array<FloatArray> {
        var bitmap = bitmap
        bitmap = resizedBitmap(bitmap, IMAGE_HEIGHT, IMAGE_WIDTH)
        convertBitmapToByteBuffer(bitmap)

        val embeddings = Array(1) { FloatArray(512) }
        tflite!!.run(imgData, embeddings)

        return embeddings
    }

    fun getSimilarityScore(face1: Bitmap, face2: Bitmap): Double {
        val face1_embedding = run(face1)
        val face2_embedding = run(face2)

        var distance = 0.0
        for (i in 0 until EMBEDDING_SIZE) {
            distance += ((face1_embedding[0][i] - face2_embedding[0][i]) * (face1_embedding[0][i] - face2_embedding[0][i])).toDouble()
        }
        distance = Math.sqrt(distance)

        return distance
    }

    fun close() {
        if (tflite != null) {
            tflite!!.close()
            tflite = null
        }
        tfliteModel = null
    }

    companion object {
        private val MODEL_PATH = "facenet.tflite"

        private val IMAGE_MEAN = 127.5f
        private val IMAGE_STD = 127.5f

        private val BATCH_SIZE = 1
        private val IMAGE_HEIGHT = 160
        private val IMAGE_WIDTH = 160
        private val NUM_CHANNELS = 3
        private val NUM_BYTES_PER_CHANNEL = 4
        private val EMBEDDING_SIZE = 512
    }

}
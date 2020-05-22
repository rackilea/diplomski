import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import com.google.gson.GsonBuilder    

class PdfGeneratorService(){

    private val ROW_INC = 20F
    private val COL_INC = 15F

    fun jsonFormat(jsonStr: String): String {

        var indentCount = 0

        val builder = StringBuilder()
        for (c in jsonStr) {
            if (indentCount > 0 && '\n' == builder.last()) {
                for (x in 0..indentCount) builder.append("    ")
            }
            when (c) {
                '{', '[' -> {
                    builder.append(c).append("\n")
                    indentCount++
                }
                ',' -> builder.append(c).append("\n")
                '}', ']' -> {
                    builder.append("\n")
                    indentCount--
                    for (x in 0..indentCount) builder.append("    ")
                    builder.append(c)
                }
                else -> builder.append(c)
            }
        }

        return builder.toString()
    }

    private fun createPdf(textToPdf: String) {
        try {
            val gSon = GsonBuilder().setPrettyPrinting().create()
            val text = gSon.toJson(jsonFormat(textToPdf))

            val rawLines = text.split("\\n")
            val jsonLines = rawLines.map { it.replace("\\", "") }
            val maxLengthString = jsonLines.maxBy { it.length }

            val paint = Paint()
            paint.color = Color.BLACK
            paint.fontSpacing

            val pageWidth = paint.measureText(maxLengthString).toInt() + 2 * COL_INC.toInt() // 2, two side padding
            val pageHeight = (ROW_INC * rawLines.size + ROW_INC).toInt()

            val document = PdfDocument()
            val pageInfo: PdfDocument.PageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 1).create()
            val page: PdfDocument.Page = document.startPage(pageInfo)
            val canvas = page.canvas

            for (line in jsonLines) {
                canvas.drawText(line, column, row, paint)
                row += ROW_INC
            }

            document.finishPage(page)
            document.writeTo(FileOutputStream(File(PATH_TO_PDF_FILE)))
            document.close()
        }catch (e: java.lang.Exception){
            Log.e("classTag", e)
        }
    }
}
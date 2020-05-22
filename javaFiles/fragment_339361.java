import java.io.InputStreamReader
import java.io.InputStream
import java.nio.charset.Charset

import scala.collection.mutable.Queue

/**
 * Reader for Metadata that is contained in the given `InputStream`.
 *
 * @constructor Create a new metadata reader with a given `Charset`.
 * @param in underlying input stream
 * @param charset encoding of the stream
 */
class MetadataReader(in: InputStream, charset: Charset)
    extends InputStreamReader(in, charset) {
  private val lookahead = Queue.empty[Int] // buffer for looking ahead
  private var afterNewline = true // indicates that the last char was a newline
  private var divider = 0 // number of divider characters in a row ('-')

  /**
   * Create new MetadataReader with the systems default `Charset`.
   *
   * @param in underlying input stream
   */
  def this(in: InputStream) = this(in, Charset.defaultCharset())

  /**
   * Read the next character.
   *
   * @return next character
   */
  override def read: Int =
    if (divider == 2) {
      -1
    } else if (!lookahead.isEmpty) {
      lookahead.dequeue
    } else {

      // read next character
      def readNext: Int =
        if (lookahead.length == 3) {
          divider += 1
          read
        } else {
          val c = super.read
          if (c == '-') {
            lookahead.enqueue(c)
            readNext
          } else {
            lookahead.enqueue(c)
            lookahead.dequeue
          }
        }

      readNext
    }

  /**
   * Read characters into a buffer character array.
   *
   * @param buf buffer array
   * @param off offset to start in the array
   * @param len number of characters to read
   * @return actually read characters
   */
  override def read(buf: Array[Char], off: Int, len: Int): Int = {
    var j = 0
    for (i <- 0 until len) {
      val c = read

      if (c == -1)
        return j

      if (i >= off) {
        buf(i) = c.toChar
        j += 1
      }
    }

    j
  }
}
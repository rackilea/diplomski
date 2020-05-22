import org.apache.spark.SparkContext

import scala.language.implicitConversions


class RichSparkContext(val sc: SparkContext) {

  def executorCount: Int =
    sc.getExecutorStorageStatus.length - 1 // one is the driver

  def coresPerExecutor: Int =
    RichSparkContext.coresPerExecutor(sc)

  def coreCount: Int =
    executorCount * coresPerExecutor

  def coreCount(coresPerExecutor: Int): Int =
    executorCount * coresPerExecutor

}


object RichSparkContext {

  trait Enrichment {
    implicit def enrichMetadata(sc: SparkContext): RichSparkContext =
      new RichSparkContext(sc)
  }

  object implicits extends Enrichment

  private var _coresPerExecutor: Int = 0

  def coresPerExecutor(sc: SparkContext): Int =
    synchronized {
      if (_coresPerExecutor == 0)
        sc.range(0, 1).map(_ => java.lang.Runtime.getRuntime.availableProcessors).collect.head
      else _coresPerExecutor
    }

}
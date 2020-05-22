import org.apache.spark.AccumulatorParam

object LineCummulatorParam extends AccumulatorParam[String] {
      def zero(value:String) : String = value
      def addInPlace(s1:String, s2:String):String = s1 + "\n" + s2
}

val debugInfo = sparkContext.accumulator("","debug info")(DebugInfoCummulatorParam)

rdd.map{rdd => ...
        ...
        ...
        //this happens on each worker
        debugInfo += "something happened here"
        }

//this happens on the driver
println(debugInfo)
val stream: DataStream[(String,Int)] =   ...

stream.keyBy(_._1)
      .window(EventTimeSessionWindows.withGap(Time.seconds(conf.sessionGap())))
      .apply((e1, e2) => (e1._1, e1._2 + e2._2),
             (key, window, in, out: Collector[(String, Long, Long, Int)]) => {
                out.collect((key, window.getStart, window.getEnd, in.map(_._2).sum))
      })
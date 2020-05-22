(...)
  remote {
    enabled-transports = ["akka.remote.netty.tcp"]
    netty.tcp {
      maximum-frame-size = 100MiB
      hostname = "YYY.YYY.YYY.YYY"
      port = 2560
    }
  }
(...)
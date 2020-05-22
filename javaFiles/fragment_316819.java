for i in {1..8}; do echo "${i}G:"; java -XX:ThreadStackSize=${i}m -XX:+PrintFlagsFinal -version 2>&1 | grep ' ThreadStack'; done
1G:
     intx ThreadStackSize                          := 1048576                             {pd product}
2G:
     intx ThreadStackSize                          := 2097152                             {pd product}
3G:
     intx ThreadStackSize                          := 3145728                             {pd product}
4G:
     intx ThreadStackSize                          := 4194304                             {pd product}
5G:
     intx ThreadStackSize                          := 5242880                             {pd product}
6G:
     intx ThreadStackSize                          := 6291456                             {pd product}
7G:
     intx ThreadStackSize                          := 7340032                             {pd product}
8G:
     intx ThreadStackSize                          := 8388608                             {pd product}
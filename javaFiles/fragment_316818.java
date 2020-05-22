for i in {1..8}; do echo "${i}G:"; java -Xss${i}g -XX:+PrintFlagsFinal -version 2>&1 | grep ' ThreadStack'; done
1G:
     intx ThreadStackSize                          := 1048576                             {pd product}
2G:
     intx ThreadStackSize                          := 18014398507384832                    {pd product}
3G:
     intx ThreadStackSize                          := 18014398508433408                    {pd product}
4G:
     intx ThreadStackSize                          := 0                                   {pd product}
5G:
     intx ThreadStackSize                          := 1048576                             {pd product}
6G:
     intx ThreadStackSize                          := 18014398507384832                    {pd product}
7G:
     intx ThreadStackSize                          := 18014398508433408                    {pd product}
8G:
     intx ThreadStackSize                          := 0                                   {pd product}
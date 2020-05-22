private val runtime = Runtime.getRuntime()
import runtime.{ totalMemory, freeMemory, maxMemory }

 System.out.println("New session, \ 
    total memory = %s, max memory = %s, free memory = %s".format(
        totalMemory, maxMemory, freeMemory))
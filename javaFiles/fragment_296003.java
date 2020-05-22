import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

ExecutorService exeSvc = Executors.newFixedThreadPool(5)
for (int element=0;element<9;element++) {
    int elementCopy = element
    exeSvc.execute({->
        Thread.sleep(567); 
        println "${Thread.currentThread()}  element = $element elementCopy = $elementCopy"; 
    });
}
println "All Started"
exeSvc.shutdown()
exeSvc.awaitTermination(10, TimeUnit.SECONDS)
println "All Finished"
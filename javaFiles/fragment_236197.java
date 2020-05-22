from(tasks)
    .multicast()
    .parallelProcessing()
        .to("direct:parallelTask1")
        .to("direct:parallelTask2")
    .end()
    .log("All tasks are terminated");

 from("direct:parallelTask1")
    .to(parallelTask1)
    .log("Task1 terminated")
    .bean(postResult, "postTask1Result");

from("direct:parallelTask2")
    .to(parallelTask2)
    .log("Task2 terminated")
    .bean(postResult, "postTask2Result");
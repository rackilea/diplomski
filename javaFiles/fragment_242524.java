package de.scrum_master.aspect;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import de.scrum_master.app.RunnableProcess;
import java.util.Map;

public privileged aspect ProcessRunInterceptorProtocol {
  pointcut runProcess(RunnableProcess process) :
    call(void RunnableProcess.run(Map)) && target(process);

  before(RunnableProcess process): runProcess(process) {
    Logger logger = getLogger(process.getClass());
    logger.info("logger = " + logger);
    logger.info("running process = " + thisJoinPoint);
  }

  after(RunnableProcess process): runProcess(process) {
    Logger logger = getLogger(process.getClass());
    logger.info("finished process = " + thisJoinPoint);
    logger.info("result = " + process.result);
  }
}
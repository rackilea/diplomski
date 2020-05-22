package com.example.myapplication.server

import akka.actor.{Props, ActorSystem}
import spray.can.Http
import akka.io.IO
import com.example.myapplication.api.MyServiceActor
import org.apache.commons.daemon._

trait ApplicationLifecycle {
  def start(): Unit
  def stop(): Unit
}

abstract class AbstractApplicationDaemon extends Daemon {
  def application: ApplicationLifecycle

  def init(daemonContext: DaemonContext) {}

  def start() = application.start()

  def stop() = application.stop()

  def destroy() = application.stop()
}

class ApplicationDaemon() extends AbstractApplicationDaemon {
  def application = new Application
}

object ServiceApplication extends App {

  val application = createApplication()

  def createApplication() = new ApplicationDaemon

  private[this] var cleanupAlreadyRun: Boolean = false

  def cleanup(){
    val previouslyRun = cleanupAlreadyRun
    cleanupAlreadyRun = true
    if (!previouslyRun) application.stop()
  }

  Runtime.getRuntime.addShutdownHook(new Thread(new Runnable {
    def run() {
      cleanup()
    }
  }))

  application.start()
}


class Application() extends ApplicationLifecycle with Logging {

  private[this] var started: Boolean = false

  private val applicationName = "MyApplication"

  implicit val actorSystem = ActorSystem(s"$applicationName-system")

  def start() {
    logger.info(s"Starting $applicationName Service")

    if (!started) {
      started = true

      val myService = actorSystem.actorOf(Props[MyServiceActor], "my-service")

      IO(Http) ! Http.Bind(myService, interface = "0.0.0.0", port = 8280)
    }
  }

  def stop() {
    logger.info(s"Stopping $applicationName Service")

    if (started) {
      started = false
      actorSystem.shutdown()
    }
  }

}
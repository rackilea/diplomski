import akka.dispatch.*;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import akka.util.Timeout;


ComputationRequest request = new ComputationRequest(1, 7, true);
MasterActor master = actorSystem.get(...);

Timeout timeout = new Timeout(Duration.create(5, "seconds"));
Future<Object> future = Patterns.ask(master, request, timeout);
ComputationResult result = (ComputationResult) Await.result(future, timeout.duration());
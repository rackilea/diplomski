import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    //inject this
    private Executor executor;

    @RequestMapping("/your/path/here")
    public String myMVCControllerGETdataMethod(Model model) {
        //define all async requests and give them to injected Executor
        List<GetRequestTask> tasks = new ArrayList<GetRequestTask>();
        tasks.add(new GetRequestTask("http://api/data?type=1", this.executor));
        tasks.add(new GetRequestTask("http://api/data?type=2", this.executor));
        //...
        //do other work here
        //...
        //now wait for all async tasks to complete
        while(!tasks.isEmpty()) {
            for(Iterator<GetRequestTask> it = tasks.iterator(); it.hasNext();) {
                GetRequestTask task = it.next();
                if(task.isDone()) {
                    String request = task.getRequest();
                    String response = task.getResponse();
                    //PUT YOUR CODE HERE
                    //possibly aggregate request and response in Map<String,String>
                    //or do something else with request and response
                    it.remove();
                }
            }
            //avoid tight loop in "main" thread
            if(!tasks.isEmpty()) Thread.sleep(100);
        }
        //now you have all responses for all async requests

        //the following from your original code
        //note: you should probably pass the responses from above
        //to this next method (to keep your controller stateless)
        String results = doWorkwithMultipleDataReturned();
        model.addAttribute(results, results);
        return "index";
    }

    //abstraction to wrap Callable and Future
    class GetRequestTask {
        private GetRequestWork work;
        private FutureTask<String> task;
        public GetRequestTask(String url, Executor executor) {
            this.work = new GetRequestWork(url);
            this.task = new FutureTask<String>(work);
            executor.execute(this.task);
        }
        public String getRequest() {
            return this.work.getUrl();
        }
        public boolean isDone() {
            return this.task.isDone();
        }
        public String getResponse() {
            try {
                return this.task.get();
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Callable representing actual HTTP GET request
    class GetRequestWork implements Callable<String> {
        private final String url;
        public GetRequestWork(String url) {
            this.url = url;
        }
        public String getUrl() {
            return this.url;
        }
        public String call() throws Exception {
            return new DefaultHttpClient().execute(new HttpGet(getUrl()), new BasicResponseHandler());
        }
    }
}
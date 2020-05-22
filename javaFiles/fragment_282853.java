import java.io.File;
import java.util.HashMap;
import java.util.Map;

class Scratch {
    public interface Worker{
        public void process(File file);
        public int getStatus();
        public int getTotal();
    }

    public class ServiceImpl{
        Map<File, Worker> workers = new HashMap<>();
        private static final int MAX = 10;

        public void process(File file){
            if(workers.size() < MAX) {
                Worker worker = null; // replace by actual implementation :)
                workers.put(file, worker);
            }else{
                throw new ArrayIndexOutOfBoundsException("max number of simultaneous operations reached, try again later");
            }
        }

        public int getStatus(File f){
            return workers.get(f).getStatus();
        }

        public int getTotal(File f){
            return workers.get(f).getTotal();
        }

        public void clean(File f){
            Worker worker = workers.get(f);
            if(worker.getStatus() == worker.getTotal()){
                workers.remove(worker);
            }else{
                throw new UnsupportedOperationException("process is not over, cannot clean it");
            }
        }


    }
}
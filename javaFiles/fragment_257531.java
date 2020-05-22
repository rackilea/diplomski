package cloud;

import java.util.HashMap;
import java.util.Map;

public class CloudStructureData {

    private Map<String, Host> hosts;
    private Map<String, Instance> instances;

    public CloudStructureData(){

        hosts = new HashMap<String, Host>(); // the key will be HostId
        instances = new HashMap<String, Instance>(); // the key will be InstanceId
    }

    public Map<String, Host> getHosts() {
        return hosts;
    }

    public Map<String, Instance> getInstances() {
        return instances;
    }

}
// bad pseudo code 

DataTask dataTask = new DataTask(dataKeys, restTemplate);
future = service.submit(dataTask);

while(!future.isDone()) {
    if( blockedHosts.contains(currentHost) ) {
        // host unreachable, don't wait for http timeout
        future.cancel(); 
    }
    thread.sleep(/* */);
}
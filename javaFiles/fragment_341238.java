private boolean isStopped = false;

public void stop() {
    isStopped = true;
}

while(bufferedReader.isReady()) {
    bufferedReader.read();
    if(isStopped) {
        bufferedReader.close();
    }
}
Class Player {

NetworkState network;

public void connectPlayer(NetworkState network){
    this.network = network;
}
public boolean isAdmin(){
     return network.isAdmin();
}

....

}
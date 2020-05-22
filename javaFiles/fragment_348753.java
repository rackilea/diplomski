// On the main class:
public ImageView getIPlay(){
    return iPlay;
}
private static MainActivity instance;
public MainActivity getInstance(){
    return instance;
}

/** Either on the constructor or the 'OnCreate' method, you should add: */
    instance = this;
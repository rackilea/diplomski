class ClientMethodCaller implements Runnable{
     ServerThread st;Object arg
     public ClientMethodCaller(ServerThread st,Object arg){this.st=st;this.arg=arg;}
     public void run () {
        st.forceToCall(arg);//signalling the client async
     }
}
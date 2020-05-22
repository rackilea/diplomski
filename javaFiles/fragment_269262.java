public synchronized String getLocalHost() {
        if(this.localHostName == null || this.localHostName.length() <= 0) {
            ***this.localHostName = this.session.getProperty("mail." + this.name + ".localhost");***
        }

        if(this.localHostName == null || this.localHostName.length() <= 0) {
            ***this.localHostName = this.session.getProperty("mail." + this.name + ".localaddress");***
        }

        InetAddress localHost;
        try {
            if(this.localHostName == null || this.localHostName.length() <= 0) {
                localHost = InetAddress.getLocalHost();
                this.localHostName = localHost.getCanonicalHostName();
                if(this.localHostName == null) {
                    this.localHostName = "[" + localHost.getHostAddress() + "]";
                }
            }
        } catch (UnknownHostException var2) {
            ;
        }

        if((this.localHostName == null || this.localHostName.length() <= 0) && this.serverSocket != null && this.serverSocket.isBound()) {
            localHost = this.serverSocket.getLocalAddress();
            this.localHostName = localHost.getCanonicalHostName();
            if(this.localHostName == null) {
                this.localHostName = "[" + localHost.getHostAddress() + "]";
            }
        }

        return this.localHostName;
}
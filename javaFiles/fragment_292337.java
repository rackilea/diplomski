public void setHost(String host) {
  // check if property actually changed
  if (Objects.equals(this.host, host) return;
  String oldHost = this.host;
  this.host = host;
  this.firePropertyChange("Host", oldHost, this.host); 
}
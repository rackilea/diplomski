public Message getCurrent() {
if(this.size() <= 0) {
    return null;
}else {
    return (this.size() > currentMessageIndex) ? this.get(currentMessageIndex) : null;
}}
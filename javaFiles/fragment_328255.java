abstract class  Helper {
    private boolean disableNotification;

    public Helper disableNotification(boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }
}

class sendMessage extends Helper {

}

class sendAudio extends Helper {

}

class Test {
    public static void Test() {
        Helper sendMessage = new sendMessage();
        Helper helper = sendMessage.disableNotification(true);
    }
}
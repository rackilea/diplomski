public class InviteTimeoutTask extends TimerTask {

    private final Invite invite;

    public InviteTimeoutTask(Invite invite) {
        this.invite = invite;
    }

    @Override
    public void run() {
        invite.setExpired(true);
    }
}
public enum Action {
    DoNotPrint,
    Print,
    PrintAndForward,
    PrintAndReply,
    Forward,
    Reply
}

public class OutgoingMessage {
     private Action action;
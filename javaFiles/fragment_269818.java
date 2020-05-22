public class MyExecutionHandler extends ExecutionHandler {
    public void handleUpstream(ctx, evt) throws Exception {
        if (evt instanceof MessageEvent) {
            Object msg = ((MessageEvent) evt).getMessage();
            if (msg instanceof ExecutionSkippable) {
                ctx.sendUpstream(evt);
                return;
            }
        }

        super.handleUpstream(evt);
    }
    ...
}
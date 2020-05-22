class App extends ... {
    App( Function<App, AppRunner> runner_creator,
         Function<App, AppPanel> panel_creator) {
        appRunner = runner_creator.apply(this);
        appPanel = panel_creator.apply(this);
}

class Pong extends App {
    Pong() {
        super(
            app -> new PongRunner(10, app),
            app -> new PongPanel(app));
    }
}
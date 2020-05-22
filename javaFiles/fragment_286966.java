...

private long startMillis;

public Test1()
{
    ...

    Timer timeDisplayer = new Timer(1000, e -> {
        time = (System.currentTimeMillis() - startMillis + 500L) / 1000L;
        text.setText(((time / 3600) % 24) + ":" + ((time / 60) % 60) + ":" + (time % 60));
    });
    timeDisplayer.setInitialDelay(0);

    ...

    startMillis = System.currentTimeMillis()
    timeDisplayer.start();
}
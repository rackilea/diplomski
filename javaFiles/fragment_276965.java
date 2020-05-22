...

static class PrinterLocator {
    ...

    static SerialPrinter[] FindPrinters(SLPDriver context) {
        ...

        ... = context.new SerialPrinter(...);
    }
}

class SerialPrinter {
    ...

    public boolean Configure(...) {
        ...

        ... = new Serial(PApplet.this, ...);
    }
}
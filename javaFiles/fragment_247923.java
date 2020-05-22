OnPrintListener imprime = new OnPrintListener() {
        @Override
        public void onPrintResult(int i) {
            i = 1;
        }
    };

    printer.startPrint(true, imprime);
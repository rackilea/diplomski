final Application application = ...;
        application.getOleMessageLoop().doInvokeAndWait(new Runnable() {
            public void run() {
                _Application app = application.getPeer();
                app.setDefaultSheetDirection(new Int32(LocaleID.LOCALE_USER_DEFAULT), new Int32(Constants.xlRTL));
            }
        });
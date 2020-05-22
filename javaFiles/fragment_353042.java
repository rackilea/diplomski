Thread t = new Thread(new Runnable() {
             @Override
             public void run() {

                 PhoneNumberFormatter.setPhoneNumberFormattingTextWatcher(thi‌​s, mRecipientsEditor);
             }
         });
        t.start();
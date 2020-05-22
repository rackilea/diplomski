Bundle b = new Bundle();

b.putString("outgoingString", outgoingText);
Message m = mhandler.obtainMessage();
m.setData(b);
mhandler.sendMessage(m);
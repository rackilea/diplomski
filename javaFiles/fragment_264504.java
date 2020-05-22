Bundle mUIMessageBundle = new Bundle(newUser.getName());
mUIMessageBundle.putInt("Name", newUser.getName());
mUIMessageBundle.putString("Tag", null);
Message msg = handler.obtainMessage(); // get a message
// msg.what = 1; // set type of message
msg.setData(mUIMessageBundle); // attach bundle
handler.sendMessage(msg);
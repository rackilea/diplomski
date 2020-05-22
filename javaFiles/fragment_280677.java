HashMap<String, String> map = new HashMap<String, String>();

ArrayList<String>k =  receivedIntent.getStringArrayListExtra("keys");
ArrayList<String>v = receivedIntent.getStringArrayListExtra("values");

for(int i = 0; i < k.size(); i++) map.put(k.get(i), v.get(i));
Hashtable<String, String> valueNick = new Hashtable<>();    
    valueNick.put("name", "Ankush");
    valueNick.put("lastName", "Soni");
        String nickStr = valueNick.toString();
        byte[] bufferNick = nickStr.getBytes();
        for (int i = 0; i < bufferNick.length; i++) {
                 System.out.print(bufferNick[i] + " ");
            }   }
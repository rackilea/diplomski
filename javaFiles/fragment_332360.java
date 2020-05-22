ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(sock.getInputStream()));

while (true) {
    Object obj = ois.readObject();

    if (obj instanceof String) {
        if ((String)obj).equalsIgnoreCase("quit")) {
            break;
        }
    }

    // handle object
}

ois.close();
sock.close();
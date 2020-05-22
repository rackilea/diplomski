if (message instanceof BytesMessage) {
                BytesMessage bm = (BytesMessage) message;
                byte data[];
                data = new byte[(int) bm.getBodyLength()];
                bm.readBytes(data);
                msgText = new String(data);
                System.out.println("Message String = "+msgText);
}
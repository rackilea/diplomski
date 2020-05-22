while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                    Socket Client = Server.accept();

                    count++;
                    System.out.println("Client Connected...." + "you have "
                            + count + " clients connected");
                    SocketChannel ClientChannel = Client.getChannel();
                    ClientChannel.configureBlocking(false);
                    ClientChannel.register(selector, SelectionKey.OP_READ);// read
                                                                            // incoming
                                                                            // stream
                } else {
                    if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                        SocketChannel Client = null;
                        Client = (SocketChannel) key.channel();
                        // client=Client;
                        // ReadClientStream();
                    }
                }
                it.remove(); // Add this to Remove Already Selected SelectionKeys 

            }
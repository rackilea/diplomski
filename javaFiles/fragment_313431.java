while (receiveData != null) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData,
                        receiveData.length);
                Socket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                fw.write(sentence.trim());
                fw.flush();
                System.out.printf("RECEIVED: %s ", new String(receivePacket
                        .getData()));
                // System.out.println("Done");
                // InetAddress IPAddress = receivePacket.getAddress();
                // int port = receivePacket.getPort();
                // String capitalizedSentence = sentence.toUpperCase();
                /*
                 * sendData = capitalizedSentence.getBytes(); DatagramPacket
                 * sendPacket = new DatagramPacket(sendData, sendData.length,
                 * IPAddress, port); serverSocket.send(sendPacket);
                 */
            }
PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(m_socket.getOutputStream())), false);
            out.print("GET /" + m_index + " HTTP/1.1\r\n"
                    + "Host: " + m_server + "\r\n"
                    + "Authorization: Basic " + m_authString + "\r\n"
                    + "Connection: close\r\n\r\n");
            out.flush();
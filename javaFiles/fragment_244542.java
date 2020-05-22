...
        } catch (Exception e) {
                System.err.println(System.currentTimeMillis()
                        + " Unexpected Error");     
                out.close();
                in.close();
                socket.close();
            }
        }
    });
    t.start();
}
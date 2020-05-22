} 
            } catch (Exception exception) {
                isConnected = false;
                sleepFewSeconds();
                reconnectSocket();
            }
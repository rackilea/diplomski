peerNetData.put(buffer,6,readdata-6);
                Log.d(TAG,"before data flipped...");
                peerNetData.flip();
                Log.d(TAG,"data flipped...");
                try {
                    do {
                    result = engine.unwrap(peerNetData, peerAppData);
                    Log.d(TAG,"data unwrapped...");
                    Log.d(TAG,"Handskes is: " + result.getHandshakeStatus().toString() +" Current Status: " +result.getStatus() + " Bytes consumed: " + result.bytesConsumed() + " bytes produce: " + result.bytesProduced());
                    } while (peerNetData.hasRemaining() || result.bytesProduced()>0);
                    peerNetData.compact();


                    Log.d(TAG,"data compacted...");
                    handshakeStatus = result.getHandshakeStatus();
                    Log.d(TAG,"Handshake status: " + handshakeStatus);
                    .....................................................
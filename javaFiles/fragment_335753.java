private void sendMessage(BluetoothGattCharacteristic characteristic, String CHARACTERS){
        byte[] initial_packet = new byte[3];
        /**
         * Indicate byte
         */
        initial_packet[0] = BLE.INITIAL_MESSAGE_PACKET;
        if (Long.valueOf(
                String.valueOf(CHARACTERS.length() + initial_packet.length))
                > BLE.DEFAULT_BYTES_VIA_BLE) {
            sendingContinuePacket(characteristic, initial_packet, CHARACTERS);
        } else {
            sendingLastPacket(characteristic, initial_packet, CHARACTERS);
        }
    }

private void sendingContinuePacket(BluetoothGattCharacteristic characteristic,
            byte[] initial_packet, String CHARACTERS){
        /**
         * TODO If data length > Default data can sent via BLE : 20 bytes
         */
        // Check the data length is large how many times with Default Data (BLE)
        int times = Byte.valueOf(String.valueOf(
                CHARACTERS.length() / BLE.DEFAULT_BYTES_IN_CONTINUE_PACKET));

        Log.i(TAG, "CHARACTERS.length() " + CHARACTERS.length());
        Log.i(TAG, "times " + times);

        // TODO
        // 100 : Success
        // 101 : Error
        byte[] sending_continue_hex = new byte[BLE.DEFAULT_BYTES_IN_CONTINUE_PACKET];
        for (int time = 0; time <= times; time++) {
            /**
             * Wait second before sending continue packet 
             */
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (time == times) {
                Log.i(TAG, "LAST PACKET ");

                /**
                 * If you do not have enough characters to send continue packet,
                 * This is the last packet that will be sent to the band
                 */

                /**
                 * Packet length byte :
                 */
                /**
                 * Length of last packet
                 */
                int character_length = CHARACTERS.length()
                        - BLE.DEFAULT_BYTES_IN_CONTINUE_PACKET*times;

                initial_packet[1] = Byte.valueOf(String.valueOf(character_length
                        + BLE.INITIAL_MESSAGE_PACKET_LENGTH));
                initial_packet[2] = BLE.SENDING_LAST_PACKET;

                Log.i(TAG, "character_length " + character_length);

                /**
                 * Message
                 */
                // Hex file
                byte[] sending_last_hex = new byte[character_length];

                // Hex file : Get next bytes
                for (int i = 0; i < sending_last_hex.length; i++) {
                    sending_last_hex[i] = 
                            CHARACTERS.getBytes()[sending_continue_hex.length*time + i];
                }

                // Merge byte[]
                byte[] last_packet = 
                        new byte[character_length + BLE.INITIAL_MESSAGE_PACKET_LENGTH];
                System.arraycopy(initial_packet, 0, last_packet,
                        0, initial_packet.length);
                System.arraycopy(sending_last_hex, 0, last_packet, 
                        initial_packet.length, sending_last_hex.length);

                // Set value for characteristic
                characteristic.setValue(last_packet);
            } else {
                Log.i(TAG, "CONTINUE PACKET ");
                /**
                 * If you have enough characters to send continue packet,
                 * This is the continue packet that will be sent to the band
                 */
                /**
                 * Packet length byte
                 */
                int character_length = sending_continue_hex.length;

                /**
                 * TODO Default Length : 20 Bytes
                 */
                initial_packet[1] = Byte.valueOf(String.valueOf(
                        character_length + BLE.INITIAL_MESSAGE_PACKET_LENGTH));

                /**
                 * If sent data length > 20 bytes (Default : BLE allow send 20 bytes one time)
                 * -> set 01 : continue sending next packet
                 * else or if after sent until data length < 20 bytes
                 * -> set 00 : last packet
                 */
                initial_packet[2] = BLE.SENDING_CONTINUE_PACKET;
                /**
                 * Message
                 */
                // Hex file : Get first 17 bytes
                for (int i = 0; i < sending_continue_hex.length; i++) {
                    Log.i(TAG, "Send stt : " 
                            + (sending_continue_hex.length*time + i));

                    // Get next bytes
                    sending_continue_hex[i] = 
                            CHARACTERS.getBytes()[sending_continue_hex.length*time + i];
                }

                // Merge byte[]
                byte[] sending_continue_packet = 
                        new byte[character_length + BLE.INITIAL_MESSAGE_PACKET_LENGTH];
                System.arraycopy(initial_packet, 0, sending_continue_packet, 
                        0, initial_packet.length);
                System.arraycopy(sending_continue_hex, 0, sending_continue_packet, 
                        initial_packet.length, sending_continue_hex.length);

                // Set value for characteristic
                characteristic.setValue(sending_continue_packet);
            }

            // Write characteristic via BLE
            mBluetoothGatt.writeCharacteristic(characteristic);
        }
    }

public boolean writeCharacteristic(BluetoothGattCharacteristic characteristic,
            String data) {
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return false;
        }

        if (ActivityBLEController.IS_FIRST_TIME) {
            /**
             * In the first time, 
             * should send the Title
             */
            byte[] merge_title = sendTitle(data);

            // Set value for characteristic
            characteristic.setValue(merge_title);

            // Write characteristic via BLE
            mBluetoothGatt.writeCharacteristic(characteristic);

            // Reset
            ActivityBLEController.IS_FIRST_TIME = false;

            return true;
        } else {
            /**
             * In the second time, 
             * should send the Message
             */
            if (data.length() <= BLE.LIMIT_CHARACTERS) {
                sendMessage(characteristic, data);

                // Reset
                ActivityBLEController.IS_FIRST_TIME = true; 

                return true;
            } else {
                // Typed character
                typed_character = data.length();

                return false;
            }
        }
    }
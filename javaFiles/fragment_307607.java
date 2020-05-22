sendString(conn, UsbAccessoryConstants.ACCESSORY_STRING_MANUFACTURER, MANUFACTURER);
sendString(conn, UsbAccessoryConstants.ACCESSORY_STRING_MODEL, MODEL);
sendString(conn, UsbAccessoryConstants.ACCESSORY_STRING_DESCRIPTION, DESCRIPTION);
sendString(conn, UsbAccessoryConstants.ACCESSORY_STRING_VERSION, VERSION);
sendString(conn, UsbAccessoryConstants.ACCESSORY_STRING_URI, URI);
sendString(conn, UsbAccessoryConstants.ACCESSORY_STRING_SERIAL, SERIAL);

// The device should re-enumerate as an accessory.
conn.controlTransfer(UsbConstants.USB_DIR_OUT | UsbConstants.USB_TYPE_VENDOR,
    UsbAccessoryConstants.ACCESSORY_START, 0, 0, null, 0, 10000);
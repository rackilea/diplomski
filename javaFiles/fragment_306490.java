int ptr = 0;
    while (count-- > 0) { 
        index = (crc >> 8) & 0xff;
        crc = ((crc & 0xff) << 8) | (pData[ptr++] & 0xff); 
        crc = crc ^ NET_CRC_TABLE[index];
    }
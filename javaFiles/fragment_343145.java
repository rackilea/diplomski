154: enum {
155:    MSG_DATA_SIZE = offsetof(struct TOS_Msg, crc) + sizeof(uint16_t), // 36 by default
156:    TINYSEC_MSG_DATA_SIZE = offsetof(struct TinySec_Msg, mac) + TINYSEC_MAC_LENGTH, // 41 by default
157:    DATA_LENGTH = TOSH_DATA_LENGTH,
158:    LENGTH_BYTE_NUMBER = offsetof(struct TOS_Msg, length) + 1,
159:    TINYSEC_NODE_ID_SIZE = sizeof(uint16_t)
160: };
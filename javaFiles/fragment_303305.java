byte[] terminalModes = {
    128,              // TTY_OP_ISPEED
    0, 0, 0x8c, 0xa0, // 36000 = 00008ca0
    129,              // TTY_OP_OSPEED
    0, 0, 0x8c, 0xa0, // 36000 again
    0,                // TTY_OP_END
};
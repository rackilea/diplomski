switch (type) {
        case WinNT.REG_DWORD :
            data = Character.toChars(Integer.parseInt(value));
            dataLength = 4;
            break;

        case WinNT.REG_SZ :
            dataLength *= 2;
            break;

        default: break;
    }
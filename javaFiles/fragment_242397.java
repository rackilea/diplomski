static void readByteCode(ByteBuffer bb) {
    while(bb.hasRemaining()) {
        switch(bb.get()&0xff) {
            case BIPUSH: // one byte embedded constant
            case LDC:    // one byte embedded constant pool index
            // follow-up: one byte embedded local variable index
            case ILOAD:  case LLOAD:  case FLOAD:  case DLOAD:  case ALOAD:
            case ISTORE: case LSTORE: case FSTORE: case DSTORE: case ASTORE: case RET:
            case NEWARRAY: // one byte embedded array type
                bb.get();
                break;

            case IINC: // one byte local variable index, another one for the constant
            case SIPUSH: // two bytes embedded constant
            case LDC_W: case LDC2_W: // two bytes embedded constant pool index
            // follow-up: two bytes embedded branch offset
            case IFEQ: case IFNE: case IFLT: case IFGE: case IFGT: case IFLE:
            case IF_ICMPEQ: case IF_ICMPNE: case IF_ICMPLT: case IF_ICMPGE:
            case IF_ICMPGT: case IF_ICMPLE: case IF_ACMPEQ: case IF_ACMPNE:
            case GOTO: case JSR: case IFNULL: case IFNONNULL:
            // follow-up: two bytes embedded constant pool index to member or type
            case GETSTATIC: case PUTSTATIC: case GETFIELD: case PUTFIELD:
            case INVOKEVIRTUAL: case INVOKESPECIAL: case INVOKESTATIC: case NEW:
            case ANEWARRAY: case CHECKCAST: case INSTANCEOF:
                bb.getShort();
                break;

            case MULTIANEWARRAY:// two bytes pool index, one byte dimension
                bb.getShort();
                bb.get();
                break;

            // follow-up: two bytes embedded constant pool index to member, two reserved
            case INVOKEINTERFACE: case INVOKEDYNAMIC:
                bb.getShort();
                bb.getShort();
                break;

            case GOTO_W: case JSR_W:// four bytes embedded branch offset
                bb.getInt();
                break;

            case LOOKUPSWITCH:
                // special handling left as an exercise for the reader...
                break;
            case TABLESWITCH:
                // special handling left as an exercise for the reader...
                break;
            case WIDE:
                int widened=bb.get()&0xff;
                bb.getShort(); // local variable index
                if(widened==IINC) {
                    bb.getShort(); // constant offset value
                }
                break;
            default: // one of the ~150 instructions taking one byte
        }
    }
}
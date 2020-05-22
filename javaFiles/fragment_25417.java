if (P1.x() < 0)
        P1.x(0);
    else if (P1.x() > srcArg.width() - 1)
        P1.x(srcArg.width() - 1);
    if (P2.x() < 0)
        P2.x(0);
    else if (P2.x() > srcArg.width() - 1)
        P2.x(srcArg.width() - 1);
    if (P1.y() < 0)
        P1.y(0);
    else if (P1.y() > srcArg.height() - 1)
        P1.y(srcArg.height() - 1);
    if (P2.y() < 0)
        P2.y(0);
    else if (P2.y() > srcArg.height() - 1)
        P2.y(srcArg.height() - 1);
    BytePointer src = new BytePointer(srcArg.getByteBuffer());

    int pos1 = (int) srcArg.widthStep() * P2.y();
    int pos2 = (int) (srcArg.widthStep() * P1.y());
    int pos3 = (int) (srcArg.widthStep() * P2.y());
    int pos4 = (int) (srcArg.widthStep() * P1.y());
    value = (float) (src.position(pos1).get(P2.x())
            + src.position(pos2).get(P1.x())
            - src.position(pos3).get(P1.x())
            - src.position(pos4).get(P2.x()));

    value = (value - centerVal)
            / (((P2.x() - P1.x()) * (P2.y() - P1.y())) - 1);
    // System.out.println(value);
    return value;
}
public int sendMouseMove(int deltaX, int deltaY) {
        intSendEvent(m_nId, EV_REL, REL_X, deltaX);
        intSendEvent(m_nId, 0, 0, 0);
        intSendEvent(m_nId, EV_REL, REL_Y, deltaY);
        intSendEvent(m_nId, 0, 0, 0);
        return 0;
    }
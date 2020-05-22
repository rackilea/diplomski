static class SerialPortReader implements SerialPortEventListener
{
    private int m_nReceptionPosition = 0;
    private boolean m_bReceptionActive = false;
    private byte[] m_aReceptionBuffer = new byte[2048];

    @Override
    public void serialEvent(SerialPortEvent p_oEvent)
    {
        byte[] aReceiveBuffer = new byte[2048];

        int nLength = 0;
        int nByte = 0;

        switch(p_oEvent.getEventType())
        {
            case SerialPortEvent.RXCHAR:
                try
                {
                    aReceiveBuffer = serialPort.readBytes();

                    for(nByte = 0;nByte < aReceiveBuffer.length;nByte++)
                    {
                        //System.out.print(String.format("%02X ",aReceiveBuffer[nByte]));

                        m_aReceptionBuffer[m_nReceptionPosition] = aReceiveBuffer[nByte];

                        // Buffer overflow protection
                        if(m_nReceptionPosition >= 2047)
                        {

                            // Reset for next packet
                            m_bReceptionActive = false;
                            m_nReceptionPosition = 0;
                        }
                        else if(m_bReceptionActive)
                        {
                            m_nReceptionPosition++;

                            // Receive at least the start of the packet including the length
                            if(m_nReceptionPosition >= 14)
                            {
                                nLength = (short)((short)m_aReceptionBuffer[10] & 0x000000FF);
                                nLength |= ((short)m_aReceptionBuffer[11] << 8) & 0x0000FF00;
                                nLength |= ((short)m_aReceptionBuffer[12] << 16) & 0x00FF0000;
                                nLength |= ((short)m_aReceptionBuffer[13] << 24) & 0xFF000000;

                                //nLength += ..; // Depending if the length in the packet include ALL bytes from the packet or only the content part

                                if(m_nReceptionPosition >= nLength)
                                {
                                    // You received at least all the content

                                    // Reset for next packet
                                    m_bReceptionActive = false;
                                    m_nReceptionPosition = 0;
                                }
                            }

                        }
                        // Start receiving only if this is a Start Of Header
                        else if(m_aReceptionBuffer[0] == '\0')
                        {
                            m_bReceptionActive = true;
                            m_nReceptionPosition = 1;
                        }
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
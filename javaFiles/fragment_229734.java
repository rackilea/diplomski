int i=0;
public void WriteMonitorData (String IP, String PC_NAME, String ttl, String gw)
{
    data[i][0]=IP;
    data[i][1]=PC_NAME;
    data[i][2]=ttl;
    data[i][3]=gw;
    i++;
    table.repaint();
    scrollPane.repaint();

}
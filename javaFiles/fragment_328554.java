public class ChannelsInformation implements Comparable<ChannelsInformation> {
    String id, channelName;
    boolean isSelected, isfavorite;



    @Override
    public int compareTo(ChannelsInformation o) {
        int b1 = this.isfavorite ? 1 : 0;
        int b2 = o.isfavorite ? 1 : 0;

        return b2 - b1;
    }

}
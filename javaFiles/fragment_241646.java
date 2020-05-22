public class Datas
{
    private String isDetail;
    private String titleContent;
    private DetailData[] detailData;

    public String getIsDetail (){
        return isDetail;
    }

    public void setIsDetail (String isDetail){
        this.isDetail = isDetail;
    }

    public String getTitleContent (){
        return titleContent;
    }

    public void setTitleContent (String titleContent){
        this.titleContent = titleContent;
    }

    public DetailData[] getDetailData (){
        return detailData;
    }

    public void setDetailData (DetailData[] detailData){
        this.detailData = detailData;
    }
}
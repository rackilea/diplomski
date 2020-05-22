public class SKT_SubHeader_s
{
   public int subLength;
   public byte subCode;
   public byte subType;
   public byte subResult;
   public byte subCause;
   public byte subSrcMSISDN[RBT_SUBSCRIBER_NO_LEN];
   public byte subDstMSISDN[RBT_SUBSCRIBER_NO_LEN];
   public byte subRsv[20];
   public string subSrvType;
   public string subSrvId;
   public string subSndType;
   public string subSndIdx;
   public string subSndCode[RBT_TONE_ID_LEN];
   public string subSndValue[RBT_TONE_ID_LEN];
   public string subMsgId;
   public byte subBillFlag;
   public string subGroupOrder;
   public string subDate[9];
   public string subGroupName[31];
   public byte subSpFlag;
   public string subBillCode[21];
   public byte subReserve[30];
   public int bodyLength;
   public SKT_body_t bodyData[1]; 

   public SKT_Subheader_s()
   {
      //Constructor, Initialize your variables here
      //e.g.
      // sublength = 0;
      //etc...
   }
}
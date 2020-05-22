public class IRIXSecurity {



    public void CheckCredentials(
            //@Body ListDebtorReqType msgBody, @Headers Map hdr,

            @XPath(value="//header:MsgGUID",namespaces = @NamespacePrefix(
                    prefix = "header",
                    uri = "http://www.insol.irix.com.au/IRIX_V1/Headers")) String msgGUID,
            @Body Document xml)
    {


        System.out.println("Check Credentials Invoked");
        System.out.println(msgGUID);
        //exchange.getOut().setBody(debtorRsType);





    }
}
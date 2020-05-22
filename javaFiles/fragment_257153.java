Map in = new HashMap();


       in.put("P_FAN_NO",reFIRequest.getFanNo());  
       Object[][] refIDS = new String[reFIRequest.getApplicantReferenceID().size()][1];

      for(int i = 0 ; i < reFIRequest.getApplicantReferenceID().size() ; i++){
         refIDS[i][0] = reFIRequest.getApplicantReferenceID().get(i);
      }
       in.put("P_REF_ID", new SqlArrayValue(refIDS));
       in.put("P_COMMENTS", reFIRequest.getComments());
       in.put("P_BILLING_FLAG", reFIRequest.getFiBillingFlag());
       Map  result = reFIJdbcCall.execute(in);
       String status = (String)result.get("P_STATUS");
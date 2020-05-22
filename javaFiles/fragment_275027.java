JSONObject jsonObject=new JSONObject();
 for(int i=1;i<=7;i++)
    {
        arr[i]="questionId_"+i+"_"+"ans_"+i;
        jsonObject.put("params_"+i,arr[i]);
    }
HashMap<String ,String> params=new HashMap<String, String>();
params.put("params",jsonObject.toString());
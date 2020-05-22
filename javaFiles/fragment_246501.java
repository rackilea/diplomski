JSONArray jArray=new JSONArray(result);
                for(int i=0;i<jArray.length();i++){
                    if(i==0){
                        String str1=jArray.getJSONObject(i).getJSONArray("mac").getString(0);
                        String str2=jArray.getJSONObject(i).getJSONArray("mac").getString(1);
                        Log.e("Mac Result", "First: "+str1+" Second: "+str2);
                    }else if(i==1){
                        String str1=jArray.getJSONObject(i).getJSONArray("ap").getString(0);
                        String str2=jArray.getJSONObject(i).getJSONArray("ap").getString(1);
                        Log.e("Ap Result", "First: "+str1+" Second: "+str2);
                    }
                }
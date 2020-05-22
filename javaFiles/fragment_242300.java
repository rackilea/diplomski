EditText text1,text2,text3,text4,text5,text6,text7,text8,text9, text21,text22,text23,text24....text 99;
EditText[] fields={text1,text2,text3,text4,text5,text6,text7,text8,text9, text21,text22,text23,text24....text 99};
//Give your edittext ids in ids array like this
int ids[]={R.id.text1,R.id.text2,R.id.text3.....R.id,text99};
int values[9][9]={};

for(int i=0;i<fiends.length;i++)
{
fields[i]=(EditText)findViewById(ids[i]);
}
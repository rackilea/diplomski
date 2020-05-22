String sp_name="";
// type
if(type==0)
  sp_name="cc_";
else
  sp_name="ccL_";
//position
if(pos==0)
  sp_name+="left";
else
  sp_name+="right";
//item
if(item>0)
  sp_name+=(item+"");
return sp_name;
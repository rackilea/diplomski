StringBuilder segTypeArray = new StringBuilder("{");
segTypeArray.append(segments.[0].getDBValue());  
for(int i = 1; i < segments.length; i++){
   segTypeArray.append("," + list.get(i).getDBValue());
}
segTypeArray.append("}");